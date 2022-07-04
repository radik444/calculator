package pro.sky.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public Number plus(Integer a, Integer b){
        return a + b;
    }
    public Number minus(Integer a, Integer b){
        return a - b;
    }
    public Number multiply(Integer a, Integer b) {
        return a * b;
    }
    public Number divide (Integer a, Integer b){
        return a.doubleValue()/b;
    }


     }