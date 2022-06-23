package uz.pdp.barcode.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import uz.pdp.barcode.dto.StockDto;
import uz.pdp.barcode.model.Product;
import uz.pdp.barcode.model.Stock;
import uz.pdp.barcode.payload.ApiResponse;
import uz.pdp.barcode.projection.StockProjection;
import uz.pdp.barcode.repository.ProductRepository;
import uz.pdp.barcode.repository.StockRepository;
import uz.pdp.barcode.service.AnswerService;
import uz.pdp.barcode.service.StockService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StockServiceImpl implements StockService {
    @Autowired
    StockRepository stockRepository;

    @Autowired
    AnswerService answerService;

    @Autowired
    ProductRepository productRepository;

    @Override
    public HttpEntity<?> getAllStock() {
        final List<StockProjection> allStock = stockRepository.getAllStock();
        return answerService.getAllObject(allStock, allStock.size());
    }

    @Override
    public HttpEntity<?> getStockById(UUID id) {
        return null;
    }

    @Override
    public HttpEntity<?> saveStock(StockDto stockDto, Errors error) {
        ResponseEntity<ApiResponse> CONFLICT = answerService.getError(error);
        if (CONFLICT != null) return CONFLICT;

        Stock stock = new Stock();
        if (stockDto.getId() != null) {
            stock.setId(stockDto.getId());
        }
        Optional<Product> product = productRepository.findById(stockDto.getProductId());
        if (!product.isPresent()) {
            return answerService.answer("ERROR", false, null, HttpStatus.CONFLICT);
        }
        UUID id = product.get().getId();
        final Optional<Stock> stock1 = stockRepository.findByProductId(id);
        if (stock1.isPresent()) {
            return addANewProductToAnOldProduct(stockDto, stock1);
        }
        return stockAddNewProduct(stockDto, stock, product);
    }

    private HttpEntity<?> stockAddNewProduct(StockDto stockDto, Stock stock, Optional<Product> product) {
        stock.setProduct(product.get());
        stock.setQuantity(stockDto.getQuantity());
        stock.setExpirationTime(stockDto.getExpirationTime());
        stock.setEntryPrice(stockDto.getEntryPrice());
        stock.setSellPrice(stockDto.getSellPrice());
        stock.setTimeOfProduct(stockDto.getTimeOfProduct());
        return answerService.saveObject(stockRepository, stock, false, null);
    }

    private HttpEntity<?> addANewProductToAnOldProduct(StockDto stockDto, Optional<Stock> stock1) {
        stock1.get().setQuantity(stock1.get().getQuantity() + stockDto.getQuantity());
        stock1.get().setExpirationTime(stockDto.getExpirationTime());
        stock1.get().setEntryPrice(stockDto.getEntryPrice());
        stock1.get().setSellPrice(stockDto.getSellPrice());
        stock1.get().setTimeOfProduct(stockDto.getTimeOfProduct());
        return answerService.saveObject(stockRepository, stock1.get(), false, null);
    }

    @Override
    public HttpEntity<?> deleteStockById(UUID id) {
        return answerService.deleteObject(stockRepository, id);
    }
}
