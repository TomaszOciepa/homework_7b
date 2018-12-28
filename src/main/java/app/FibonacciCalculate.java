package app;

import javax.enterprise.context.ApplicationScoped;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class FibonacciCalculate {


    public List<FibonacciElement> generateFibonacciElements(long element) {

        List<FibonacciElement> fibonacciElementList = new LinkedList<>();

        if (element == 0){
              FibonacciElement fibonacciElement0 = new FibonacciElement(0, 0);
            fibonacciElementList.add(fibonacciElement0);

            return fibonacciElementList;
        }

        if (element == 1) {
            FibonacciElement fibonacciElement1 = new FibonacciElement(1, 1);
            fibonacciElementList.add(fibonacciElement1);

            return fibonacciElementList;
        }

        if (element == 2) {
            FibonacciElement fibonacciElement1 = new FibonacciElement(1, 1);
            fibonacciElementList.add(fibonacciElement1);

            FibonacciElement fibonacciElement2 = new FibonacciElement(2, 1);
            fibonacciElementList.add(fibonacciElement2);

            return fibonacciElementList;
        }


        FibonacciElement fibonacciElement1 = new FibonacciElement(1, 1);
        fibonacciElementList.add(fibonacciElement1);

        FibonacciElement fibonacciElement2 = new FibonacciElement(2, 1);
        fibonacciElementList.add(fibonacciElement2);

        int prev1 = 1;
        int prev2 = 1;

        for (int i = 3; i <= element; i++) {

            int currentElement = prev1 + prev2;
            FibonacciElement fibonacciObjectN = new FibonacciElement(i, currentElement);
            fibonacciElementList.add(fibonacciObjectN);
            prev2 = prev1;
            prev1 = currentElement;

        }

        return fibonacciElementList;

    }

}
