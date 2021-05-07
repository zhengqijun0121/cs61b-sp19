public class NBody {
    /** Returns the radius of the universe in that file */
    public static double readRadius(String filename) {
        In in = new In(filename);
        in.readInt();
        return in.readDouble();
    }

    /** Returns an array of five planets in the file */
    public static Body[] readBodies(String filename) {
        In in = new In(filename);
        int number = in.readInt();
        Body[] bodies = new Body[number];

        in.readDouble();
        for (int i = 0; i < number; i++) {
            bodies[i] = new Body(in.readDouble(), in.readDouble(), in.readDouble(),
                                 in.readDouble(), in.readDouble(), in.readString());
        }

        return bodies;
    }

    /**
     * Draws the universe in its starting position
     */
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Please enter command line arguments.");
            System.out.println("e.g. java NBody 157788000.0 25000.0 data/planets.txt");
            return;
        }

        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = NBody.readRadius(filename);
        Body[] bodies = NBody.readBodies(filename);

        /* Draw the Background */
        StdDraw.enableDoubleBuffering();
        StdDraw.clear();
        StdDraw.setScale(-radius, radius);
        StdDraw.picture(0, 0, "images/starfield.jpg");

        /* Draw the Sun and four Planets */
        for (Body b : bodies) {
            b.draw();
        }

        /* Display the sun and four planets sitting motionless */
        StdDraw.show();

        /* Animation */
        for (double time = 0; time <= T; time += dt) {
            double[] xForces = new double[bodies.length];
            double[] yForces = new double[bodies.length];
            for (int i = 0; i < bodies.length; i++) {
                xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
                yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
            }

            for (int i = 0; i < bodies.length; i++) {
                bodies[i].update(dt, xForces[i], yForces[i]);
            }

            StdDraw.clear();
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (Body b : bodies) {
                b.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
        }

        /* Printing the Universe */
        StdOut.printf("%d\n", bodies.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < bodies.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                          bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
                          bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);
        }
    }
}
