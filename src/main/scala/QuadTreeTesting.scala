import java.awt.event.{ActionEvent, ActionListener}
import java.awt.{Color, Dimension, FlowLayout, GridLayout}
import java.io.File

import com.sksamuel.scrimage.Image
import com.sksamuel.scrimage.filter._
import com.sksamuel.scrimage.nio.JpegWriter
import javax.imageio.ImageIO
import javax.swing.{JButton, JFrame, JLabel, JPanel, _}
object QuadTreeTesting {
  def main(args: Array[String]): Unit = {
    /* Calling Functions */
    Quadtree()
    FilterDither()
    FilterGrayScale()
    FilterEdge()
    FilterEmboss()
    FilterThreshold()
    FilterSolarize()
    /* ***Calling Functions*** */
    
    var originalImg=QuadTreeRGB.loadingImgMap(filename="PPM-Original/lena.ppm").get
    val jpg_image = ImageIO.read(new File("PPM-Original/Filter.jpg"))
    var originaLabel = new JLabel(new ImageIcon(originalImg.image))
    val jpg_label = new JLabel(new ImageIcon(jpg_image))
    val frame = new JFrame("QuadTree")  //Title of a jframe
    frame.setSize(new Dimension(1400, 900)) //Dimentions of Jframe
    val original_img = new JButton("ORIGINAL-PPM") // Button for PPM
    val quadtree1 = new JButton("QUADTREE") // Button for PPM
    val color_reversed = new JButton("COLOR REVERSED")// Button for PPM
    val mirror_image = new JButton("MIRROR IMAGE")// Button for PPM
    val inversed_image = new JButton("INVERSE IMAGE")// Button for PPM
    val original_jpg = new JButton("ORIGINAL-JPG") // Button forJPG Filters
    val dither = new JButton("DITHER")// Button forJPG Filters
    val grayscale = new JButton("GRAYSCALE")// Button forJPG Filters
    val edge = new JButton("EDGE")// Button forJPG Filters
    val emboss = new JButton("EMBOSS")// Button forJPG Filters
    val blackandwhite = new JButton("BLACK & WHITE")// Button forJPG Filters
    val solarize = new JButton("SOLARIZE")// Button forJPG Filters
    val jpanel = new JPanel()
    //val panel2 = new JPanel()
    val x = 200
    val y = 100
    jpanel.setLayout(new FlowLayout())
    jpanel.setBackground(Color.darkGray);
    jpanel.setPreferredSize(new Dimension(x,y));
    jpanel.add(original_img)
    jpanel.add(quadtree1)
    jpanel.add(color_reversed)
    jpanel.add(mirror_image)
    jpanel.add(inversed_image)
    jpanel.add(original_jpg)
    jpanel.add(dither)
    jpanel.add(grayscale)
    jpanel.add(edge)
    jpanel.add(emboss)
    jpanel.add(blackandwhite)
    jpanel.add(solarize)
    jpanel.add(originaLabel)
    jpanel.add(jpg_label)

    // ****************Perform Actions on Buttons************************

    original_img.addActionListener(new ActionListener {
      override def actionPerformed(e: ActionEvent): Unit = {
        originalImg=QuadTreeRGB.loadingImgMap(filename="PPM-Original/lena.ppm").get
        val jpg_image = ImageIO.read(new File("PPM-Original/Filter.jpg"))
        val jpg_label = new JLabel(new ImageIcon(jpg_image))
        originaLabel = new JLabel(new ImageIcon(originalImg.image))
        frame.getContentPane.removeAll;
        frame.add(jpanel)
        frame.add(new JPanel().add(originaLabel))
        frame.add(new JPanel().add(jpg_label))
        frame.validate()
        println("ORIGINAL-PPM-FILE")
      }
    })

   quadtree1.addActionListener(new ActionListener {
      override def actionPerformed(e: ActionEvent): Unit = {
        originalImg=QuadTreeRGB.loadingImgMap(filename="PPM-Outcome/Quadtree.ppm").get
        originaLabel = new JLabel(new ImageIcon(originalImg.image))
        frame.getContentPane.removeAll;
        frame.add(jpanel)
        frame.add(new JPanel().add(originaLabel))
        frame.validate()
        println("QUADTREE")
      }
    })

    color_reversed.addActionListener(new ActionListener {
      override def actionPerformed(e: ActionEvent): Unit = {
        val inverseImg=QuadTreeRGB.loadingImgMap(filename="PPM-Outcome/Quadtree-ColorReversed.ppm").get
        val	inverseLabel = new JLabel(new ImageIcon(inverseImg.image))
        frame.getContentPane.removeAll();
        frame.add(jpanel)
        frame.add(new JPanel().add(inverseLabel))
        frame.validate()
        println("COLOR-REVERSED")
      }
    })

    mirror_image.addActionListener(new ActionListener {
      override def actionPerformed(e: ActionEvent): Unit = {
        val mirrorImg=QuadTreeRGB.loadingImgMap(filename="PPM-Outcome/Quadtree-Mirror.ppm").get
        val	mirrorLabel = new JLabel(new ImageIcon(mirrorImg.image))
        frame.getContentPane.removeAll;
        frame.add(jpanel)
        frame.add(new JPanel().add(mirrorLabel))
        frame.validate()
        println("MIRROR-IMAGE")
      }
    })

    inversed_image.addActionListener(new ActionListener {
      override def actionPerformed(e: ActionEvent): Unit = {
        val mirrorImg=QuadTreeRGB.loadingImgMap(filename="PPM-Outcome/Quadtree-transpose.ppm").get
        val	mirrorLabel = new JLabel(new ImageIcon(mirrorImg.image))
        frame.getContentPane.removeAll;
        frame.add(jpanel)
        frame.add(new JPanel().add(mirrorLabel))
        frame.validate()
        println("TRANSPOSE-IMAGE")
      }
    })


    original_jpg.addActionListener(new ActionListener {
      override def actionPerformed(e: ActionEvent): Unit = {
        val outputfile = new File("PPM-Original/Filter.jpg").getPath
        val	inverseLabel1 = new JLabel(new ImageIcon(outputfile))
        frame.getContentPane.removeAll();
        frame.add(jpanel)
        frame.add(new JPanel().add(inverseLabel1))
        frame.validate()
        println("ORIGINAL-JPG-FILE")
      }
    })

    dither.addActionListener(new ActionListener {
      override def actionPerformed(e: ActionEvent): Unit = {
        val outputfile = new File("PPM-Outcome/dither.jpg").getPath
        val	inverseLabel1 = new JLabel(new ImageIcon(outputfile))
        frame.getContentPane.removeAll();
        frame.add(jpanel)
        frame.add(new JPanel().add(inverseLabel1))
        frame.validate()
        println("DITHER-FILTER")
      }
    })

    grayscale.addActionListener(new ActionListener {
      override def actionPerformed(e: ActionEvent): Unit = {
        val outputfile = new File("PPM-Outcome/grayscale.jpg").getPath
        val	inverseLabel2 = new JLabel(new ImageIcon(outputfile))
        frame.getContentPane.removeAll();
        frame.add(jpanel)
        frame.add(new JPanel().add(inverseLabel2))
        frame.validate()
        println("GRAYSCALE-FILTER")
      }
    })

    edge.addActionListener(new ActionListener {
      override def actionPerformed(e: ActionEvent): Unit = {
        val outputfile = new File("PPM-Outcome/edge.jpg").getPath
        val	inverseLabel3 = new JLabel(new ImageIcon(outputfile))
        frame.getContentPane.removeAll();
        frame.add(jpanel)
        frame.add(new JPanel().add(inverseLabel3))
        frame.validate()
        println("EDGE-FILTER")
      }
    })

    emboss.addActionListener(new ActionListener {
      override def actionPerformed(e: ActionEvent): Unit = {
        val outputfile = new File("PPM-Outcome/emboss.jpg").getPath
        val	inverseLabel4 = new JLabel(new ImageIcon(outputfile))
        frame.getContentPane.removeAll();
        frame.add(jpanel)
        frame.add(new JPanel().add(inverseLabel4))
        frame.validate()
        println("EMBOSS-FILTER")
      }
    })

    blackandwhite.addActionListener(new ActionListener {
      override def actionPerformed(e: ActionEvent): Unit = {
        val outputfile = new File("PPM-Outcome/blackandwhite.jpg").getPath
        val	inverseLabel4 = new JLabel(new ImageIcon(outputfile))
        frame.getContentPane.removeAll();
        frame.add(jpanel)
        frame.add(new JPanel().add(inverseLabel4))
        frame.validate()
        println("BLACK-&-WHITE-FILTER")
      }
    })

    solarize.addActionListener(new ActionListener {
      override def actionPerformed(e: ActionEvent): Unit = {
        val outputfile = new File("PPM-Outcome/solarize.jpg").getPath
        val	inverseLabel4 = new JLabel(new ImageIcon(outputfile))
        frame.getContentPane.removeAll();
        frame.add(jpanel)
        frame.add(new JPanel().add(inverseLabel4))
        frame.validate()
        println("SOLARIZE-FILTER")
      }
    })

    frame.setLayout(new GridLayout(1,1))
    frame.getContentPane.add(jpanel)
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    frame.setLocationRelativeTo(null)
    frame.setVisible(true)
    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName())
  }
  def Quadtree() : Unit = {
    val img = QuadTreeRGB.loadingImgMap(filename = "PPM-Original/lena.ppm").get
    val width = img.width
    val height = img.height

    val matrixRed = Array.ofDim[Int](width, height)
    val matrixGreen = Array.ofDim[Int](width, height)
    val matrixBlue = Array.ofDim[Int](width, height)

    val matrixRedC = Array.ofDim[Int](width, height)
    val matrixGreenC = Array.ofDim[Int](width, height)
    val matrixBlueC = Array.ofDim[Int](width, height)

    for (i <- 0 until width) {
      for (j <- 0 until height) {
        matrixRed(i)(j) = img.getPixel(i, j).getRed
        matrixGreen(i)(j) = img.getPixel(i, j).getGreen
        matrixBlue(i)(j) = img.getPixel(i, j).getBlue

        matrixRedC(i)(j) = 255 - img.getPixel(i, j).getRed /* Color Reversed*/
        matrixGreenC(i)(j) = 255 - img.getPixel(i, j).getGreen /* Color Reversed*/
        matrixBlueC(i)(j) = 255 - img.getPixel(i, j).getBlue /* Color Reversed*/
      }
    }
    val matrixRed2 = matrixRed.transpose
    val matrixGreen2 = matrixGreen.transpose
    val matrixBlue2 = matrixBlue.transpose


    /* threshold value is useful to control the pixels of an image */
    val threshold: Float = (19).toFloat
    val quadTree: RGBPixel = new RGBPixel(0, 0, width, height, threshold, matrixRed, matrixGreen, matrixBlue)
    val quadTree1: RGBPixel = new RGBPixel(0, 0, width, height, threshold, matrixRed.reverse, matrixGreen.reverse, matrixBlue.reverse)
    val quadTree4: RGBPixel = new RGBPixel(0, 0, width, height, threshold, matrixRedC, matrixGreenC, matrixBlueC)
    val quadTree5 : RGBPixel = new RGBPixel(0,0,width,height,threshold,matrixRed2.reverse,matrixGreen2.reverse,matrixBlue2.reverse)
    QuadTreeRGB.save(width, height, quadTree, filename = "PPM-Outcome/Quadtree.ppm")
    QuadTreeRGB.save(width, height, quadTree1, filename = "PPM-Outcome/Quadtree-Mirror.ppm")
    QuadTreeRGB.save(width, height, quadTree4, filename = "PPM-Outcome/Quadtree-ColorReversed.ppm")
    QuadTreeRGB.save(width, height, quadTree5, filename="PPM-Outcome/Quadtree-transpose.ppm")
  }

  def FilterDither(): Unit = {
    val inFile = new File("PPM-Original/Filter.jpg")
    val outputfile = new File("PPM-Outcome/dither.jpg")
    Image.fromFile(inFile).filter(DitherFilter).output(outputfile)(JpegWriter())
  }

  def FilterGrayScale(): Unit = {
    val inFile = new File("PPM-Original/Filter.jpg")
    val outputfile1 = new File("PPM-Outcome/grayscale.jpg")
    Image.fromFile(inFile).filter(GrayscaleFilter).output(outputfile1)(JpegWriter())
  }
  def FilterEdge(): Unit = {
    val inFile = new File("PPM-Original/Filter.jpg")
    val outputfile2 = new File("PPM-Outcome/edge.jpg")
    Image.fromFile(inFile).filter(EdgeFilter).output(outputfile2)(JpegWriter())
  }
  def FilterEmboss(): Unit = {
    val inFile = new File("PPM-Original/Filter.jpg")
    val outputfile3 = new File("PPM-Outcome/emboss.jpg")
    Image.fromFile(inFile).filter(EmbossFilter).output(outputfile3)(JpegWriter())
  }
  def FilterThreshold(): Unit = {
    val inFile = new File("PPM-Original/Filter.jpg")
    val outputfile5 = new File("PPM-Outcome/blackandwhite.jpg")
    Image.fromFile(inFile).filter(ThresholdFilter()).output(outputfile5)(JpegWriter())
  }
  def FilterSolarize(): Unit = {
    val inFile = new File("PPM-Original/Filter.jpg")
    val outputfile6 = new File("PPM-Outcome/solarize.jpg")
    Image.fromFile(inFile).filter(SolarizeFilter).output(outputfile6)(JpegWriter())
  }
}