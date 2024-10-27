package sdax0.cpu;


import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
public class SimpleOperations {

    int i1 = 7793;
    int i2 = 3923;

    int si1 = 10;
    int si2 = 5;

    Integer I1 = i1;
    Integer I2 = i2;

    double d1 = 394720.30472943;
    double d2 = 20394.203728932;

    @Benchmark
    public void doNothing() {
        // intentionally empty
    }

    @Benchmark
    public int intAddition() {
        return i1 + i2;
    }

    @Benchmark
    public int dependentAdditions() {
        int x = i1 + si2;
        return x + i2;
    }

    @Benchmark
    public void independentAdditions(Blackhole bh) {
        int x = i1 + si1;
        int y = i2 + si2;
        bh.consume(x);
        bh.consume(y);
    }

    @Benchmark
    public Integer integerAddition() {
        return I1 + I2;
    }

    @Benchmark
    public double doubleAddition() {
        return d1 + d2;
    }

    @Benchmark
    public double doubleMultiplication() {
        return d1 * d2;
    }

    @Benchmark
    public int intToIntDivision() {
        return si1 / si2;
    }

    @Benchmark
    public double intToDoubleDivision() {
        return i2 / (double)i1;
    }

    @Benchmark
    public double doubleDivision() {
        return d1 / d2;
    }



}
