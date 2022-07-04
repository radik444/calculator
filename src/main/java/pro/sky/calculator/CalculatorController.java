package pro.sky.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String greetings() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam(value = "num1", required = false) Integer a,
                       @RequestParam(value = "num2", required = false) Integer b) {
        if (Objects.isNull(a) || Objects.isNull(b)) {
            return "Оба параметра должны быть переданы";
        }
        return buildResult(a,b,calculatorService.plus(a,b),"+");
    }

    @GetMapping("/minus")
    public String minus(@RequestParam(value = "num1", required = false) Integer a,
                        @RequestParam(value = "num2", required = false) Integer b) {
        if (Objects.isNull(a) || Objects.isNull(b)) {
            return "Оба параметра должны быть переданы";
        }
        return buildResult(a,b,calculatorService.minus(a,b),"-");
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam(value = "num1", required = false) Integer a,
                       @RequestParam(value = "num2", required = false) Integer b) {
        if (Objects.isNull(a) || Objects.isNull(b)) {
            return "Оба параметра должны быть переданы";
        }
        return buildResult(a,b,calculatorService.multiply(a,b),"*");
    }

     @GetMapping("/divide")
    public String divide(@RequestParam(value = "num1", required = false) Integer a,
                       @RequestParam(value = "num2", required = false) Integer b) {
        if (Objects.isNull(a) || Objects.isNull(b)) {
            return "Оба параметра должны быть переданы";
        }
        if(b==0){
            return "На ноль делить нельзя";
        }
        return buildResult(a,b,calculatorService.divide(a,b),"/");
    }


    private String buildResult(Integer a, Integer b, Number result, String operation){
        return a + " " + operation + " " + b + " = " + result;
    }

}

