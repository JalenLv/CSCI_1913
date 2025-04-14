
public class Tester {
    public static void main(String[] args) {
        RGBImage img, out;
        Transformation t;
        Transformation[] transformations;

        // example 1 -- Transformation class
        // img = RGBImageUtil.load("bruininks.png");
        // t = new Transformation();
        // out = t.transform(img);
        // RGBImageUtil.showImage(img);
        // RGBImageUtil.showImage(out);
        // RGBImageUtil.saveImage(out, "your_bruininks_T.png");

        // example 2 -- greyscale
        // img = RGBImageUtil.load("bruininks_inside.png");
        // t = new Greyscale();
        // out = t.transform(img);
        // RGBImageUtil.showImage(img);
        // RGBImageUtil.showImage(out);
        // RGBImageUtil.saveImage(out, "your_bruininks_inside_G.png");

        // example 3 -- Brighten
        // img =
        // RGBImageUtil.load("Southeast_Steam_Plant-University_of_Minnesota-large.png");
        // t = new Brighten(110);
        // out = t.transform(img);
        // RGBImageUtil.showImage(img);
        // RGBImageUtil.showImage(out);
        // RGBImageUtil.saveImage(out,
        // "your_Southeast_Steam_Plant-University_of_Minnesota-large_b110.png");

        // example 4 -- Brighten
        // img =
        // RGBImageUtil.load("Southeast_Steam_Plant-University_of_Minnesota-large.png");
        // t = new Brighten(-40);
        // out = t.transform(img);
        // RGBImageUtil.showImage(img);
        // RGBImageUtil.showImage(out);
        // RGBImageUtil.saveImage(out,
        // "your_Southeast_Steam_Plant-University_of_Minnesota-large_bn40.png");

        // example 5 -- AddBorder
        // img = RGBImageUtil.load("thumb.png");
        // t = new AddBorder(1, new RGBColor(0, 255, 0));
        // out = t.transform(img);
        // RGBImageUtil.showImage(img);
        // RGBImageUtil.showImage(out);
        // RGBImageUtil.saveImage(out, "your_thumb_A1green.png");

        // example 6 -- AddBorder
        // img = RGBImageUtil.load("thumb.png");
        // t = new AddBorder(10, new RGBColor(255, 0, 255));
        // out = t.transform(img);
        // RGBImageUtil.showImage(img);
        // RGBImageUtil.showImage(out);
        // RGBImageUtil.saveImage(out, "your_thumb_A10purple.png");

        // example 7 -- AddBorder
        // img = RGBImageUtil.load("University_of_Minnesota_entrance_sign_1-large.png");
        // t = new AddBorder(10, new RGBColor(255, 255, 0));
        // out = t.transform(img);
        // RGBImageUtil.showImage(img);
        // RGBImageUtil.showImage(out);
        // RGBImageUtil.saveImage(out,
        // "your_University_of_Minnesota_entrance_sign_1-large_A10yellow.png");

        // example 8 -- ColorPallet
        // img = RGBImageUtil.load("UMN-CivilEngineering-large.png");
        // t = new ColorPallet(new RGBColor[] {
        // new RGBColor(60, 59, 110),
        // new RGBColor(255, 255, 255),
        // new RGBColor(178, 34, 52)
        // });
        // out = t.transform(img);
        // RGBImageUtil.showImage(img);
        // RGBImageUtil.showImage(out);
        // RGBImageUtil.saveImage(out, "your_UMN-CivilEngineering-large_Pamerica.png");

        // example 9 -- ColorPallet
        // img = RGBImageUtil.load("Platonic_figure_at_UMN-large.png");
        // t = new ColorPallet(new RGBColor[] {
        // new RGBColor(160, 154, 188),
        // new RGBColor(182, 166, 202),
        // new RGBColor(213, 207, 225),
        // new RGBColor(225, 222, 233),
        // new RGBColor(212, 190, 190)
        // });
        // out = t.transform(img);
        // RGBImageUtil.showImage(img);
        // RGBImageUtil.showImage(out);
        // RGBImageUtil.saveImage(out, "your_Platonic_figure_at_UMN-large_Pliliac.png");

        // example 10 -- Stamp
        // img = RGBImageUtil.load("groovy.png");
        // t = new Stamp(RGBImageUtil.load("thumb.png"));
        // out = t.transform(img);
        // RGBImageUtil.showImage(img);
        // RGBImageUtil.showImage(out);
        // RGBImageUtil.saveImage(out, "your_groovy_Sthumb.png");

        // example 11 -- Stamp
        // img = RGBImageUtil.load("bruininks.png");
        // t = new Stamp(RGBImageUtil.load("groovy.png"));
        // out = t.transform(img);
        // RGBImageUtil.showImage(img);
        // RGBImageUtil.showImage(out);
        // RGBImageUtil.saveImage(out, "your_bruininks_Sgroovy.png");

        // Example 12 -- transformation util.
        transformations = new Transformation[] {
                new AddBorder(13, new RGBColor(238, 130, 238)), // violet
                new AddBorder(11, new RGBColor(75, 0, 130)), // indigo
                new AddBorder(9, new RGBColor(0, 0, 255)), // blue
                new AddBorder(7, new RGBColor(0, 128, 0)), // green
                new AddBorder(5, new RGBColor(255, 255, 0)), // yellow
                new AddBorder(3, new RGBColor(255, 165, 0)), // orange
                new AddBorder(1, new RGBColor(255, 0, 0)), // red

        };
        TransformationUtils.transformMany(transformations, "thumb.png", "your_thumb_many_rainbow.png");
        RGBImageUtil.showImage(RGBImageUtil.load("thumb.png"));
        RGBImageUtil.showImage(RGBImageUtil.load("your_thumb_many_rainbow.png"));

        // Example 13 -- transformation util.
        transformations = new Transformation[] {
                new Greyscale(),
                new AddBorder(10, new RGBColor(0, 0, 255)),
                new Stamp(RGBImageUtil.load("thumb.png"))
        };
        TransformationUtils.transformMany(transformations, "bruininks.png", "your_bruininks_many.png");
        RGBImageUtil.showImage(RGBImageUtil.load("bruininks.png"));
        RGBImageUtil.showImage(RGBImageUtil.load("your_bruininks_many.png"));

        // Example 14 -- transformation util.
        transformations = new Transformation[] {
                new Brighten(100),
                new ColorPallet(new RGBColor[] {
                        new RGBColor(160, 154, 188),
                        new RGBColor(182, 166, 202),
                        new RGBColor(213, 207, 225),
                        new RGBColor(225, 222, 233),
                        new RGBColor(212, 190, 190) }),
                new Brighten(-100),
                new Stamp(RGBImageUtil.load("thumb.png"))
        };
        TransformationUtils.transformMany(transformations,
                "Platonic_figure_at_UMN-large.png",
                "your_Platonic_figure_at_UMN-large_many.png");
        RGBImageUtil.showImage(RGBImageUtil.load("Platonic_figure_at_UMN-large.png"));
        RGBImageUtil.showImage(RGBImageUtil.load("your_Platonic_figure_at_UMN-large_many.png"));
    }
}
