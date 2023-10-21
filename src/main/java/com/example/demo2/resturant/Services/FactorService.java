package com.example.demo2.resturant.Services;
import com.example.demo2.resturant.Dto.FactorDetailsReport;
import com.example.demo2.resturant.Dto.FactorReport;
import com.example.demo2.resturant.Models.FactorModel;
import com.example.demo2.resturant.Repository.FactorRepository;
import com.example.demo2.resturant.Repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
public class FactorService {
    OrderRepository orderRepository;
    FactorRepository factorRepository;

    public FactorService(FactorRepository factorRepository, OrderRepository orderRepository) {
        this.factorRepository = factorRepository;
        this.orderRepository = orderRepository;
    }

    public List<FactorReport> getFactors() {
        return factorRepository.findFactors(Sort.by("dateFactor").descending().and(Sort.by("timeFactor").descending()));
    }

    public List<FactorDetailsReport> getFactorById(Integer factorId) {
        return factorRepository.findFactorById(factorId);
    }

    public List<FactorReport> getFactorByDate(String factorDate) {
        return factorRepository.findFactorByDate(factorDate);
    }

    public List<FactorReport> getFactorByPersonId(Integer personId) {
        return factorRepository.findFactorByPersonId(personId);
    }

    public String deleteFactorAndOrders(Integer codeFactor) {

        FactorModel factorModel = new FactorModel();
        if (factorRepository.findById(codeFactor).isPresent()) {
            //factorRepository.deleteByDate("2023-10-11");
            factorRepository.deleteById(codeFactor);
            return "record was Deleted Successfully";
        } else
            return "record was not found";

    }
}
