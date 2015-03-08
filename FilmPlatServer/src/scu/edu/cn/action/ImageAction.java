package scu.edu.cn.action;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Random;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

 

public class ImageAction extends ActionSupport {

    /**

     * ��֤���Ӧ��Session��

     */

    private static final String SessionName = "CheckCodeImageAction";

    /**

     * �������������֤�������Դ

     */

    private static final char[] source = new char[]{

       'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',

       'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',

       'U', 'V', 'W', 'X', 'Y', 'Z',

       '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'

    };

    /**

     * ���������ӡ��֤����ַ���ɫ

     */

    private static final Color[] colors = new Color[]{

       Color.RED, Color.BLUE, Color.BLACK

    };

    /**

     * ���ڴ�ӡ��֤�������

     */

    private static final Font font = new Font("����", Font.BOLD, 16);

    /**

     * ��������������������������

     */

    private static final Random rdm = new Random();

   

    private String text = "";

   

    private byte[] bytes = null;

    private String contentType = "image/png";

   

    public byte[] getImageBytes(){

       return this.bytes;

    }

    public String getContentType(){

       return this.contentType;

    }

   

    public void setContentType(String value){

       this.contentType = value;

    }

   

    public int getContentLength(){

       return bytes.length;

    }

   

    /**

     * ���ɳ���Ϊ4������ַ���

     */

    private void generateText(){

       char[] source = new char[4];

       for(int i=0; i<source.length; i++){

           source[i] = ImageAction.source[rdm.nextInt(ImageAction.source.length)];

       }

       this.text = new String(source);

       // ����Session

       ServletActionContext.getRequest().getSession().setAttribute(SessionName, this.text);
    }

   

    /**

     * ���ڴ������ɴ�ӡ������ַ�����ͼƬ

     * @return ���ڴ��д����Ĵ�ӡ���ַ�����ͼƬ

     */

    private BufferedImage createImage(){

       int width = 40;

       int height = 20;

      

       BufferedImage image =

           new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

      

       Graphics g = image.getGraphics();

       g.setColor(Color.LIGHT_GRAY);

       g.fillRect(0, 0, width, height);

      

       g.setFont(font);

       for(int i=0; i<this.text.length(); i++){

           g.setColor(colors[rdm.nextInt(colors.length)]);

           g.drawString(this.text.substring(i, i+1), 2 + i * 8, 16);

       }

       g.dispose();

      

       return image;

    }

   

    /**

     * ����ͼƬ�����ֽ�����

     * @param image ���ڴ����ֽ������ͼƬ

     */

    private void generatorImageBytes(BufferedImage image){

       ByteArrayOutputStream bos = new ByteArrayOutputStream();

       try{

           javax.imageio.ImageIO.write(image, "jpg", bos);

           this.bytes = bos.toByteArray();

       }catch(Exception ex){

       }finally{

           try{

              bos.close();

           }catch(Exception ex1){

           }

       }

    }

 

    /**

     * ��struts2���������õķ���

     * @return ��Զ�����ַ���"image"

     */

    public String doDefault(){

      

       this.generateText();

       BufferedImage image = this.createImage();

       this.generatorImageBytes(image);

      

       return "image";

    }

}

 