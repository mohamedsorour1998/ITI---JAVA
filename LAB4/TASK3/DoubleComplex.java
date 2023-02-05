public class DoubleComplex implements Complex<Double> {
    private double real;
    private double imaginary;

    // getter
    public Double getReal() {
        return real;
    }

    public Double getImaginary() {
        return imaginary;
    }

    // constructor
    public DoubleComplex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // add
    @Override
    public Complex<Double> add(Complex<Double> z) {
        return new DoubleComplex(real + z.getReal(), imaginary + z.getImaginary());
    }

    // subtract
    @Override
    public Complex<Double> subtract(Complex<Double> z) {
        return new DoubleComplex(real - z.getReal(), imaginary - z.getImaginary());
    }

    // product
    @Override
    public Complex<Double> product(Complex<Double> z) {
        return new DoubleComplex(real * z.getReal() - imaginary * z.getImaginary(),
                real * z.getImaginary() + imaginary * z.getReal());
    }

    // div
    @Override
    public Complex<Double> div(Complex<Double> z) {
        double denominator = z.getReal() * z.getReal() + z.getImaginary() * z.getImaginary();
        return new DoubleComplex((real * z.getReal() + imaginary * z.getImaginary()) / denominator,
                (imaginary * z.getReal() - real * z.getImaginary()) / denominator);
    }

    public String toString() {
        return real + "+" + imaginary + "i";
    }

}