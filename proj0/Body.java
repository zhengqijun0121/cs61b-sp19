public class Body {
    double xxPos;  /* Its current x position */
    double yyPos;  /* Its current y position */
    double xxVel;  /* Its current velocity in the x direction */
    double yyVel;  /* Its current velocity in the y direction */
    double mass;   /* Its mass */
    String imgFileName;  /* The name of the file that corresponds to the image that depicts the body */
    private static final double G = 6.67e-11;  /* The gravitational constant */

    /** Initializes the Body class */
    public Body(double xP, double yP, double xV, double yV, double m, String img) {
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    /** Initializes the Body class with an existing Body */
    public Body(Body b) {
        this.xxPos = b.xxPos;
        this.yyPos = b.yyPos;
        this.xxVel = b.xxVel;
        this.yyVel = b.yyVel;
        this.mass = b.mass;
        this.imgFileName = b.imgFileName;
    }

    /** Returns the distance between two Bodys */
    public double calcDistance(Body b) {
        return Math.sqrt(Math.pow((b.xxPos - this.xxPos), 2) + Math.pow((b.yyPos - this.yyPos), 2));
    }

    /** Returns the total force */
    public double calcForceExertedBy(Body b) {
        return G * this.mass * b.mass / Math.pow(calcDistance(b), 2);
    }

    /** Returns the force in the X directions */
    public double calcForceExertedByX(Body b) {
        return calcForceExertedBy(b) * (b.xxPos - this.xxPos) / calcDistance(b);
    }

    /** Returns the force in the Y directions */
    public double calcForceExertedByY(Body b) {
        return calcForceExertedBy(b) * (b.yyPos - this.yyPos) / calcDistance(b);
    }

    /** Returns the net X force exerted by all bodies upon the current Body */
    public double calcNetForceExertedByX(Body[] bodies) {
        double sum = 0;
        for (Body b : bodies) {
            if (b.equals(this)) {
                continue;
            } else {
                sum += calcForceExertedByX(b);
            }
        }
        return sum;
    }

    /** Returns the net Y force exerted by all bodies upon the current Body */
    public double calcNetForceExertedByY(Body[] bodies) {
        double sum = 0;
        for (Body b : bodies) {
            if (b.equals(this)) {
                continue;
            } else {
                sum += calcForceExertedByY(b);
            }
        }
        return sum;
    }

    /** Updates the body’s position and velocity */
    public void update(double dt, double fX, double fY) {
        double aX = fX / this.mass;
        double aY = fY / this.mass;
        this.xxVel += dt * aX;
        this.yyVel += dt * aY;
        this.xxPos += dt * this.xxVel;
        this.yyPos += dt * this.yyVel;
    }

    /** Draws the Body’s image at the Body’s position */
    public void draw() {
        String filename = "images/" + this.imgFileName;
        StdDraw.picture(this.xxPos, this.yyPos, filename);
    }
}
