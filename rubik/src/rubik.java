import java.awt.*;
import java.applet.Applet;

public final class rubik extends Applet
{
    int i;
    int j;
    int k;
    int n;
    int o;
    int p;
    int q;
    int lastX;
    int lastY;
    int dx;
    int dy;
    int rectX[];
    int rectY[];
    Color colList[];
    Color bgcolor;
    final double sideVec[] = { 0.0, 0.0, 1.0, 0.0, 0.0, -1, 0.0, -1, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, -1, 0.0, 0.0 };
    final double corners[] = { -1, -1, -1, 1.0, -1, -1, 1.0, 1.0, -1, -1, 1.0, -1, -1, -1, 1.0, 1.0, -1, 1.0, 1.0, 1.0, 1.0, -1, 1.0, 1.0 };
    double topCorners[];
    double botCorners[];
    final int sides[] = { 4, 5, 6, 7, 3, 2, 1, 0, 0, 1, 5, 4, 1, 2, 6, 5, 2, 3, 7, 6, 0, 4, 7, 3 };
    final int nextSide[] = { 2, 3, 4, 5, 4, 3, 2, 5, 1, 3, 0, 5, 1, 4, 0, 2, 1, 5, 0, 3, 2, 0, 4, 1 };
    final int mainBlocks[] = { 0, 3, 0, 3, 0, 3, 0, 3, 0, 3, 0, 3, 0, 3, 0, 3, 0, 3, 0, 3, 0, 3, 0, 3 };
    final int twistDir[] = { -1, 1, -1, 1, -1, 1, -1, 1, 1, 1, 1, 1, 1, -1, 1, -1, 1, 1, 1, 1, -1, 1, -1, 1 };
    final int colDir[] = { -1, -1, 1, -1, 1, -1 };
    final int circleOrder[] = { 0, 1, 2, 5, 8, 7, 6, 3 };
    int topBlocks[];
    int botBlocks[];
    int sideCols[];
    int sideW;
    int sideH;
    int dragReg;
    int twistSide;
    int nearSide[];
    int buffer[];
    double dragCorn[];
    double dragDir[];
    double eye[] = { 0.3651, 0.1826, -0.9129 };
    double eX[] = { 0.9309, -0.0716, 0.3581 };
    double eY[];
    double Teye[];
    double TeX[];
    double TeY[];
    double light[];
    double temp[] = { 0.0, 0.0, 0.0 };
    double temp2[] = { 0.0, 0.0, 0.0 };
    double newCoord[];
    double sx;
    double sy;
    double sdxh;
    double sdyh;
    double sdxv;
    double sdyv;
    double d;
    double t1;
    double t2;
    double t3;
    double t4;
    double t5;
    double t6;
    double phi;
    double phibase;
    double Cphi;
    double Sphi;
    double currDragDir[];
    boolean naturalState;
    boolean twisting;
    boolean OKtoDrag;
	double local0;
    Math m;
    Graphics offGraphics;
    Image offImage;

    public void init()
    {
        offImage = createImage(120, 120);
        offGraphics = offImage.getGraphics();
        rectX = new int[4];
        rectY = new int[4];
        newCoord = new double[16];
        dragDir = new double[24];
        dragCorn = new double[96];
        topCorners = new double[24];
        botCorners = new double[24];
        topBlocks = new int[24];
        botBlocks = new int[24];
        buffer = new int[12];
        nearSide = new int[12];
        light = new double[3];
        Teye = new double[3];
        TeX = new double[3];
        TeY = new double[3];
        currDragDir = new double[2];
        eY = new double[3];
        vecProd(eye, 0, eX, 0, eY, 0);
        normalize(eY, 0);
        colList = new Color[120];
        for (i = 0; i < 20; i++)
        {
            colList[i] = new Color(103 + i * 8, 103 + i * 8, 103 + i * 8);
            colList[i + 20] = new Color(i * 6, i * 6, 84 + i * 9);
            colList[i + 40] = new Color(84 + i * 9, i * 5, i * 5);
            colList[i + 60] = new Color(i * 6, 84 + i * 9, i * 6);
            colList[i + 80] = new Color(84 + i * 9, 84 + i * 9, i * 6);
            colList[i + 100] = new Color(84 + i * 9, 55 + i * 8, i * 3);
        }
        sideCols = new int[54];
        for (i = 0; i < 54; i++)
            sideCols[i] = i / 9;
        bgcolor = findBGColor();
        resize(125, 125);
        repaint();
    }

    public Color findBGColor()
    {
        Color color;
        String string2 = "0123456789abcdef";
        int an[] = new int[6];
        String string1 = getParameter("bgcolor");
        if (string1 != null && string1.length() == 6)
        {
            for (i = 0; i < 6; i++)
                for (j = 0; j < 16; j++)
                    if (string1.charAt(i) == string2.charAt(j))
                        an[i] = j;
            color = new Color(an[0] * 16 + an[1], an[2] * 16 + an[3], an[4] * 16 + an[5]);
        }
        else
            color = Color.lightGray;
        return color;
    }

    public double scalProd(double ad1[], int i, double ad2[], int j)
    {
        return ad1[i] * ad2[j] + ad1[i + 1] * ad2[j + 1] + ad1[i + 2] * ad2[j + 2];
    }

    public double vNorm(double ad[], int i)
    {
        return Math.sqrt(ad[i] * ad[i] + ad[i + 1] * ad[i + 1] + ad[i + 2] * ad[i + 2]);
    }

    public double cosAng(double ad1[], int i, double ad2[], int j)
    {
        return scalProd(ad1, i, ad2, j) / (vNorm(ad1, i) * vNorm(ad2, j));
    }

    public void normalize(double ad[], int i)
    {
        local0 = vNorm(ad, i);
        ad[i] = ad[i] / local0;
        ad[i + 1] = ad[i + 1] / local0;
        ad[i + 2] = ad[i + 2] / local0;
    }

    public void scalMult(double ad[], int i, double d)
    {
        ad[i] = ad[i] * d;
        ad[i + 1] = ad[i + 1] * d;
        ad[i + 2] = ad[i + 2] * d;
    }

    public void addVec(double ad1[], int i, double ad2[], int j)
    {
        ad2[j] += ad1[i];
        ad2[j + 1] += ad1[i + 1];
        ad2[j + 2] += ad1[i + 2];
    }

    public void subVec(double ad1[], int i, double ad2[], int j)
    {
        ad2[j] -= ad1[i];
        ad2[j + 1] -= ad1[i + 1];
        ad2[j + 2] -= ad1[i + 2];
    }

    public void copyVec(double ad1[], int i, double ad2[], int j)
    {
        ad2[j] = ad1[i];
        ad2[j + 1] = ad1[i + 1];
        ad2[j + 2] = ad1[i + 2];
    }

    public void vecProd(double ad1[], int i, double ad2[], int j, double ad3[], int k)
    {
        ad3[k] = ad1[i + 1] * ad2[j + 2] - ad1[i + 2] * ad2[j + 1];
        ad3[k + 1] = ad1[i + 2] * ad2[j] - ad1[i] * ad2[j + 2];
        ad3[k + 2] = ad1[i] * ad2[j + 1] - ad1[i + 1] * ad2[j];
    }

    public void cutUpCube()
    {
        for (i = 0; i < 24; i++)
        {
            topCorners[i] = corners[i];
            botCorners[i] = corners[i];
        }
        copyVec(sideVec, 3 * twistSide, temp, 0);
        copyVec(temp, 0, temp2, 0);
        scalMult(temp, 0, 1.3333);
        scalMult(temp2, 0, 0.6667);
        for (i = 0; i < 8; i++)
        {
            boolean flag = false;
            for (j = 0; j < 4; j++)
                if (i == sides[twistSide * 4 + j])
                    flag = true;
            if (flag)
                subVec(temp2, 0, botCorners, i * 3);
            else
                addVec(temp, 0, topCorners, i * 3);
        }
        for (i = 0; i < 24; i++)
        {
            topBlocks[i] = mainBlocks[i];
            botBlocks[i] = mainBlocks[i];
        }
        for (i = 0; i < 6; i++)
        {
            if (i == twistSide)
            {
                botBlocks[i * 4 + 1] = 0;
                botBlocks[i * 4 + 3] = 0;
            }
            else
            {
                k = -1;
                for (j = 0; j < 4; j++)
                    if (nextSide[i * 4 + j] == twistSide)
                        k = j;
                switch (k)
                {
                case 0:
                    topBlocks[i * 4 + 3] = 1;
                    botBlocks[i * 4 + 2] = 1;
                    break;

                case 1:
                    topBlocks[i * 4] = 2;
                    botBlocks[i * 4 + 1] = 2;
                    break;

                case 2:
                    topBlocks[i * 4 + 2] = 2;
                    botBlocks[i * 4 + 3] = 2;
                    break;

                case 3:
                    topBlocks[i * 4 + 1] = 1;
                    botBlocks[i * 4] = 1;
                    break;

                case -1:
                    topBlocks[i * 4 + 1] = 0;
                    topBlocks[i * 4 + 3] = 0;
                    break;
                }
            }
        }
    }

    public boolean keyDown(Event event, int i)
    {
        if (i == 114)
        {
            twisting = false;
            naturalState = true;
            for (this.i = 0; this.i < 54; this.i++)
                sideCols[this.i] = this.i / 9;
            repaint();
        }
        else if (i == 115)
        {
            twisting = false;
            naturalState = true;
            for (this.i = 0; this.i < 20; this.i++)
                colorTwist((int)(Math.random() * 6), (int)(Math.random() * 3 + 1.0));
            repaint();
        }
        return false;
    }

    public boolean mouseDrag(Event event, int i, int j)
    {
        if (!twisting && OKtoDrag)
        {
            OKtoDrag = false;
            boolean flag = false;
            for (this.i = 0; this.i < dragReg; this.i++)
            {
                double d1 = dragCorn[this.i * 8 + 1] - dragCorn[this.i * 8];
                double d2 = dragCorn[this.i * 8 + 5] - dragCorn[this.i * 8 + 4];
                double d3 = dragCorn[this.i * 8 + 3] - dragCorn[this.i * 8];
                double d4 = dragCorn[this.i * 8 + 7] - dragCorn[this.i * 8 + 4];
                double d5 = (d4 * ((double)lastX - dragCorn[this.i * 8]) - d3 * ((double)lastY - dragCorn[this.i * 8 + 4])) / (d1 * d4 - d3 * d2);
                double d6 = (-d2 * ((double)lastX - dragCorn[this.i * 8]) + d1 * ((double)lastY - dragCorn[this.i * 8 + 4])) / (d1 * d4 - d3 * d2);
                if (d5 > 0.0 && d5 < 1.0 && d6 > 0.0 && d6 < 1.0)
                {
                    currDragDir[0] = dragDir[this.i * 2];
                    currDragDir[1] = dragDir[this.i * 2 + 1];
                    d = currDragDir[0] * (i - lastX) + currDragDir[1] * (j - lastY);
                    d = d * d / ((currDragDir[0] * currDragDir[0] + currDragDir[1] * currDragDir[1]) * ((i - lastX) * (i - lastX) + (j - lastY) * (j - lastY)));
                    if (d > 0.6)
                    {
                        flag = true;
                        twistSide = nearSide[this.i];
                        this.i = 100;
                    }
                }
            }
            if (flag)
            {
                if (naturalState)
                {
                    cutUpCube();
                    naturalState = false;
                }
                twisting = true;
                phi = 0.02 * (currDragDir[0] * (i - lastX) + currDragDir[1] * (j - lastY)) / Math.sqrt(currDragDir[0] * currDragDir[0] + currDragDir[1] * currDragDir[1]);
                repaint();
                return false;
            }
        }
        OKtoDrag = false;
        if (!twisting)
        {
            dx = lastX - i;
            copyVec(eX, 0, temp, 0);
            scalMult(temp, 0, (double)dx * 0.016);
            addVec(temp, 0, eye, 0);
            vecProd(eY, 0, eye, 0, eX, 0);
            normalize(eX, 0);
            normalize(eye, 0);
            dy = j - lastY;
            copyVec(eY, 0, temp, 0);
            scalMult(temp, 0, (double)dy * 0.016);
            addVec(temp, 0, eye, 0);
            vecProd(eye, 0, eX, 0, eY, 0);
            normalize(eY, 0);
            normalize(eye, 0);
            lastX = i;
            lastY = j;
            repaint();
        }
        else
        {
            phi = 0.02 * (currDragDir[0] * (i - lastX) + currDragDir[1] * (j - lastY)) / Math.sqrt(currDragDir[0] * currDragDir[0] + currDragDir[1] * currDragDir[1]);
            repaint();
        }
        return false;
    }

    public boolean mouseDown(Event event, int i, int j)
    {
        lastX = i;
        lastY = j;
        OKtoDrag = true;
        return false;
    }

    public boolean mouseUp(Event event, int i, int j)
    {
        if (twisting)
        {
            double d;
            twisting = false;
            phibase += phi;
            phi = 0.0;
            for (d = phibase; d < 0.0; d += 125.662) /* null body */ ;
            int k = (int)(d * 3.183);
            if (k % 5 == 0 || k % 5 == 4)
            {
                k = (k + 1) / 5 % 4;
                if (colDir[twistSide] < 0)
                    k = (4 - k) % 4;
                phibase = 0.0;
                naturalState = true;
                colorTwist(twistSide, k);
            }
            repaint();
        }
        return false;
    }

    public void colorTwist(int i1, int j1)
    {
        int k4 = 0;
        int j4 = j1 * 2;
        for (int k1 = 0; k1 < 8; k1++)
        {
            buffer[j4] = sideCols[i1 * 9 + circleOrder[k1]];
            j4 = (j4 + 1) % 8;
        }
        for (int i2 = 0; i2 < 8; i2++)
            sideCols[i1 * 9 + circleOrder[i2]] = buffer[i2];
        j4 = j1 * 3;
        for (int j2 = 0; j2 < 4; j2++)
        {
            for (int i3 = 0; i3 < 4; i3++)
                if (nextSide[nextSide[i1 * 4 + j2] * 4 + i3] == i1)
                    k4 = i3;
            for (int j3 = 0; j3 < 3; j3++)
            {
                switch (k4)
                {
                case 0:
                    buffer[j4] = sideCols[nextSide[i1 * 4 + j2] * 9 + j3];
                    break;

                case 1:
                    buffer[j4] = sideCols[nextSide[i1 * 4 + j2] * 9 + 2 + 3 * j3];
                    break;

                case 2:
                    buffer[j4] = sideCols[nextSide[i1 * 4 + j2] * 9 + 8 - j3];
                    break;

                case 3:
                    buffer[j4] = sideCols[nextSide[i1 * 4 + j2] * 9 + 6 - 3 * j3];
                    break;
                }
                j4 = (j4 + 1) % 12;
            }
        }
        j4 = 0;
        for (int k2 = 0; k2 < 4; k2++)
        {
            for (int k3 = 0; k3 < 4; k3++)
                if (nextSide[nextSide[i1 * 4 + k2] * 4 + k3] == i1)
                    k4 = k3;
            for (int i4 = 0; i4 < 3; i4++)
            {
                switch (k4)
                {
                case 0:
                    sideCols[nextSide[i1 * 4 + k2] * 9 + i4] = buffer[j4];
                    break;

                case 1:
                    sideCols[nextSide[i1 * 4 + k2] * 9 + 2 + 3 * i4] = buffer[j4];
                    break;

                case 2:
                    sideCols[nextSide[i1 * 4 + k2] * 9 + 8 - i4] = buffer[j4];
                    break;

                case 3:
                    sideCols[nextSide[i1 * 4 + k2] * 9 + 6 - 3 * i4] = buffer[j4];
                    break;
                }
                j4++;
            }
        }
    }

    public void paint(Graphics g)
    {
        dragReg = 0;
        offGraphics.setColor(bgcolor);
        offGraphics.fillRect(0, 0, 120, 120);
        if (naturalState)
            fixBlock(eye, eX, eY, corners, mainBlocks, 0);
        else
        {
            copyVec(eye, 0, Teye, 0);
            copyVec(eX, 0, TeX, 0);
            Cphi = Math.cos(phi + phibase);
            Sphi = -Math.sin(phi + phibase);
            switch (twistSide)
            {
            case 0:
                Teye[0] = Cphi * eye[0] + Sphi * eye[1];
                TeX[0] = Cphi * eX[0] + Sphi * eX[1];
                Teye[1] = -Sphi * eye[0] + Cphi * eye[1];
                TeX[1] = -Sphi * eX[0] + Cphi * eX[1];
                break;

            case 1:
                Teye[0] = Cphi * eye[0] - Sphi * eye[1];
                TeX[0] = Cphi * eX[0] - Sphi * eX[1];
                Teye[1] = Sphi * eye[0] + Cphi * eye[1];
                TeX[1] = Sphi * eX[0] + Cphi * eX[1];
                break;

            case 2:
                Teye[0] = Cphi * eye[0] - Sphi * eye[2];
                TeX[0] = Cphi * eX[0] - Sphi * eX[2];
                Teye[2] = Sphi * eye[0] + Cphi * eye[2];
                TeX[2] = Sphi * eX[0] + Cphi * eX[2];
                break;

            case 3:
                Teye[1] = Cphi * eye[1] + Sphi * eye[2];
                TeX[1] = Cphi * eX[1] + Sphi * eX[2];
                Teye[2] = -Sphi * eye[1] + Cphi * eye[2];
                TeX[2] = -Sphi * eX[1] + Cphi * eX[2];
                break;

            case 4:
                Teye[0] = Cphi * eye[0] + Sphi * eye[2];
                TeX[0] = Cphi * eX[0] + Sphi * eX[2];
                Teye[2] = -Sphi * eye[0] + Cphi * eye[2];
                TeX[2] = -Sphi * eX[0] + Cphi * eX[2];
                break;

            case 5:
                Teye[1] = Cphi * eye[1] - Sphi * eye[2];
                TeX[1] = Cphi * eX[1] - Sphi * eX[2];
                Teye[2] = Sphi * eye[1] + Cphi * eye[2];
                TeX[2] = Sphi * eX[1] + Cphi * eX[2];
                break;
            }
            vecProd(Teye, 0, TeX, 0, TeY, 0);
            if (scalProd(eye, 0, sideVec, twistSide * 3) < 0.0)
            {
                fixBlock(Teye, TeX, TeY, topCorners, topBlocks, 2);
                fixBlock(eye, eX, eY, botCorners, botBlocks, 1);
            }
            else
            {
                fixBlock(eye, eX, eY, botCorners, botBlocks, 1);
                fixBlock(Teye, TeX, TeY, topCorners, topBlocks, 2);
            }
        }
        g.drawImage(offImage, 0, 0, this);
    }

    public void update(Graphics g)
    {
        paint(g);
    }

    public void fixBlock(double ad1[], double ad2[], double ad3[], double ad4[], int an[], int i)
    {
        copyVec(ad1, 0, light, 0);
        scalMult(light, 0, -3);
        addVec(ad2, 0, light, 0);
        subVec(ad3, 0, light, 0);
        for (this.i = 0; this.i < 8; this.i++)
        {
            newCoord[this.i * 2] = 60 + 35.1 * scalProd(ad4, this.i * 3, ad2, 0);
            newCoord[this.i * 2 + 1] = 60 - 35.1 * scalProd(ad4, this.i * 3, ad3, 0);
        }
        for (this.i = 0; this.i < 6; this.i++)
        {
            if (scalProd(ad1, 0, sideVec, 3 * this.i) > 0.001)
            {
                k = (int)(9.6 * (1.0 - cosAng(light, 0, sideVec, 3 * this.i)));
                offGraphics.setColor(Color.black);
                for (j = 0; j < 4; j++)
                {
                    rectX[j] = (int)newCoord[2 * sides[this.i * 4 + j]];
                    rectY[j] = (int)newCoord[2 * sides[this.i * 4 + j] + 1];
                }
                offGraphics.fillPolygon(rectX, rectY, 4);
                sideW = an[this.i * 4 + 1] - an[this.i * 4];
                sideH = an[this.i * 4 + 3] - an[this.i * 4 + 2];
                if (sideW > 0)
                {
                    sx = newCoord[2 * sides[this.i * 4]];
                    sy = newCoord[2 * sides[this.i * 4] + 1];
                    sdxh = (newCoord[2 * sides[this.i * 4 + 1]] - sx) / sideW;
                    sdxv = (newCoord[2 * sides[this.i * 4 + 3]] - sx) / sideH;
                    sdyh = (newCoord[2 * sides[this.i * 4 + 1] + 1] - sy) / sideW;
                    sdyv = (newCoord[2 * sides[this.i * 4 + 3] + 1] - sy) / sideH;
                    p = an[this.i * 4 + 2];
                    for (n = 0; n < sideH; n++)
                    {
                        q = an[this.i * 4];
                        for (o = 0; o < sideW; o++)
                        {
                            rectX[0] = (int)(sx + ((double)o + 0.1) * sdxh + ((double)n + 0.1) * sdxv);
                            rectX[1] = (int)(sx + ((double)o + 0.9) * sdxh + ((double)n + 0.1) * sdxv);
                            rectX[2] = (int)(sx + ((double)o + 0.9) * sdxh + ((double)n + 0.9) * sdxv);
                            rectX[3] = (int)(sx + ((double)o + 0.1) * sdxh + ((double)n + 0.9) * sdxv);
                            rectY[0] = (int)(sy + ((double)o + 0.1) * sdyh + ((double)n + 0.1) * sdyv);
                            rectY[1] = (int)(sy + ((double)o + 0.9) * sdyh + ((double)n + 0.1) * sdyv);
                            rectY[2] = (int)(sy + ((double)o + 0.9) * sdyh + ((double)n + 0.9) * sdyv);
                            rectY[3] = (int)(sy + ((double)o + 0.1) * sdyh + ((double)n + 0.9) * sdyv);
                            offGraphics.setColor(colList[20 * sideCols[this.i * 9 + p * 3 + q] + k]);
                            offGraphics.fillPolygon(rectX, rectY, 4);
                            q++;
                        }
                        p++;
                    }
                }
                switch (i)
                {
                case 0:
                    t1 = sx;
                    t2 = sy;
                    t3 = sdxh;
                    t4 = sdyh;
                    t5 = sdxv;
                    t6 = sdyv;
                    for (j = 0; j < 4; j++)
                    {
                        dragCorn[8 * dragReg] = t1;
                        dragCorn[8 * dragReg + 4] = t2;
                        dragCorn[8 * dragReg + 3] = t1 + t5;
                        dragCorn[8 * dragReg + 7] = t2 + t6;
                        t1 = t1 + t3 * 3;
                        t2 = t2 + t4 * 3;
                        dragCorn[8 * dragReg + 1] = t1;
                        dragCorn[8 * dragReg + 5] = t2;
                        dragCorn[8 * dragReg + 2] = t1 + t5;
                        dragCorn[8 * dragReg + 6] = t2 + t6;
                        dragDir[dragReg * 2] = t3 * twistDir[this.i * 4 + j];
                        dragDir[dragReg * 2 + 1] = t4 * twistDir[this.i * 4 + j];
                        d = t3;
                        t3 = t5;
                        t5 = -d;
                        d = t4;
                        t4 = t6;
                        t6 = -d;
                        nearSide[dragReg] = nextSide[this.i * 4 + j];
                        dragReg++;
                    }
                    break;

                case 2:
                    if (this.i != twistSide && sideW > 0)
                    {
                        if (sideW == 3)
                        {
                            if (an[this.i * 4 + 2] == 0)
                            {
                                dragDir[dragReg * 2] = sdxh * twistDir[this.i * 4];
                                dragDir[dragReg * 2 + 1] = sdyh * twistDir[this.i * 4];
                            }
                            else
                            {
                                dragDir[dragReg * 2] = -sdxh * twistDir[this.i * 4 + 2];
                                dragDir[dragReg * 2 + 1] = -sdyh * twistDir[this.i * 4 + 2];
                            }
                        }
                        else if (an[this.i * 4] == 0)
                        {
                            dragDir[dragReg * 2] = -sdxv * twistDir[this.i * 4 + 3];
                            dragDir[dragReg * 2 + 1] = -sdyv * twistDir[this.i * 4 + 3];
                        }
                        else
                        {
                            dragDir[dragReg * 2] = sdxv * twistDir[this.i * 4 + 1];
                            dragDir[dragReg * 2 + 1] = sdyv * twistDir[this.i * 4 + 1];
                        }
                        for (j = 0; j < 4; j++)
                        {
                            dragCorn[dragReg * 8 + j] = newCoord[2 * sides[this.i * 4 + j]];
                            dragCorn[dragReg * 8 + 4 + j] = newCoord[2 * sides[this.i * 4 + j] + 1];
                        }
                        nearSide[dragReg] = twistSide;
                        dragReg++;
                    }
                    break;
                }
            }
        }
    }

    public rubik()
    {
        twistSide = -1;
        //eye = { 0.3651, 0.1826, -0.9129 };
        //eX = { 0.9309, -0.0716, 0.3581 };
        //temp = { 0.0, 0.0, 0.0 };
        //temp2 = { 0.0, 0.0, 0.0 };
        naturalState = true;
        twisting = false;
        OKtoDrag = false;
    }
}
