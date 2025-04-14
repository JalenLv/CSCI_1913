// Name: Qiming Lyu

public class TransformationUtils {
    /**
     * This function performs multiple transformations on an image.
     *
     * @param transformations -- An array of Transformation objects to be applied
     * @param inptfle         -- The input file path
     * @param otpFle          -- The output file path
     */
    public static void transformMany(Transformation[] transformations, String inptfle, String otpFle) {
        // load input image
        RGBImage img = RGBImageUtil.load(inptfle);

        // do transformations
        RGBImage out = img;
        for (Transformation transformation : transformations)
            out = transformation.transform(out);

        // save the final output image
        RGBImageUtil.saveImage(out, otpFle);
    }
}
