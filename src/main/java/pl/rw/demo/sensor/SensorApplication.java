package pl.rw.demo.sensor;

import io.reactivex.Observable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class SensorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SensorApplication.class, args);

        /*Observable<String> names = Observable.just("Aaaa", "Bbbb");
        names.startWith("First").subscribe(System.out::println);

        Observable.just(1, 2, 3)
                .mergeWith(Observable.just(4, 5, 6))
                .subscribe(System.out::println);

        Observable<String> observable1 = Observable.error(new IllegalArgumentException("aaa"));
        Observable<String> observable2 = Observable.just("Four", "Five", "Six");
        Observable.mergeDelayError(observable1, observable2)
                .subscribe(System.out::println);*/

        /*Observable<String> fnames = Observable.just("Faaaa", "Fbbb", "Fcccc");
        Observable<String> lnames = Observable.just("Laaa", "Lbbb", "Lcccc");
        fnames.zipWith(lnames, (first, last) -> first + " " + last)
                .subscribe(System.out::println);*/

       /* Observable<Long> news = Observable.interval(100, TimeUnit.MILLISECONDS);
        Observable<Long> weather = Observable.interval(50, TimeUnit.MILLISECONDS);
        Observable.combineLatest(news, weather,
                (newsTimes, weatherTimes) ->
                "Refreshed news: " + newsTimes + "times and weather: " + weatherTimes + "times")
                .subscribe(System.out::println);*/

       /*Observable<Observable<String>> timeIntervals =
               Observable.interval(1, TimeUnit.SECONDS)
                    .map(ticks -> Observable.interval(100, TimeUnit.MILLISECONDS)
                        .map(innerInterval -> "outer: " + ticks + "; inner: " + innerInterval));
       Observable.switchOnNext(timeIntervals)
               .subscribe(System.out::println);*/


        /*CountDownLatch countDownLatch = new CountDownLatch(1);
        Observable<Long> first = Observable.intervalRange(1, 10, 0, 20, TimeUnit.MILLISECONDS).map(f -> f*8);
        Observable<Long> second = Observable.intervalRange(1, 10, 100, 20, TimeUnit.MILLISECONDS).map(s -> s*7);

        Observable.combineLatest(first.startWith(0L), second.startWith(0L), SensorApplication::count).subscribe(System.out::println);
        // first.mergeWith(second).scan(0L, SensorApplication::count).subscribe(System.out::println);

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static Long count(Long first, Long last) {
        System.out.println("Values: " + first + ":" + last);
        return first + last;
    }*/
    }
}
