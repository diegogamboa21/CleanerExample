package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Andres
 */
public class Map{
    
    private int size;
    private int rectSize;
    private List<WorldObject> dust;
    private List<WorldObject> bots;
//    private BufferedImage image = Map.getBufferedImage("baldosa.jpg", this);
//    private BufferedImage image2 = Map.getBufferedImage("baldosa2.jpg", this);
//    private BufferedImage image3 = Map.getBufferedImage("cleanerbot.jpg", this);
    
    private List<RectangleObject> imagesRect;
    private List<RectangleObject> imagesDust;
    private List<RectangleObject> imagesBots;

    public Map(int size, int numOfDust) {
        this.size = size;
        this.bots = new ArrayList<>();
        this.dust = new ArrayList<>();
        imagesRect = new ArrayList<>();
        imagesDust = new ArrayList<>();
        imagesBots = new ArrayList<>();
        rectSize = 600/size;
        for (int i = 0; i < numOfDust; i++) {
            Random r = new Random();
            int x = r.nextInt(size);
            int y = r.nextInt(size);
            dust.add(new WorldObject(x, y, "dust_"+i));
            RectangleObject rec = new RectangleObject(x*rectSize, y*rectSize + (rectSize/2), rectSize/2, rectSize/2 );
            imagesDust.add(rec);
        }
        for (int i = 0; i < size*size; i++) {
            RectangleObject rec = new RectangleObject((i%size)*rectSize, (i/size)*rectSize, rectSize, rectSize);
            imagesRect.add(rec);
        }
        
    }

//    @Override
//    public void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        Graphics2D g2d = (Graphics2D)g;
//        for (int i = 0; i < size*size; i++) {
//            g2d.setPaint(imagesPaint.get(i));
//            g2d.fill(imagesRect.get(i));
//            g2d.setPaint(Color.blue);
//            g2d.draw(imagesRect.get(i));
//        }
//        for (int i = 0; i < dust.size(); i++) {
//            g2d.setPaint(imagesPaintDust.get(i));
//            g2d.fill(imagesDust.get(i));
//            g2d.setPaint(Color.gray);
//            g2d.draw(imagesDust.get(i));
//        }
//        for (int i = 0; i < bots.size(); i++) {
//            g2d.setPaint(imagesPaintBots.get(i));
//            g2d.fill(imagesBots.get(i));
//            g2d.setPaint(Color.gray);
//            g2d.draw(imagesBots.get(i));
//        }
//    }
    
//    public static BufferedImage getBufferedImage(String imageFile, Component c) {
//        Image image = c.getToolkit().getImage(imageFile);
//        waitForImage(image, c);
//        BufferedImage bufferedImage = new BufferedImage(image.getWidth(c), image.getHeight(c), BufferedImage.TYPE_INT_RGB);
//        Graphics2D g2d = bufferedImage.createGraphics();
//        g2d.drawImage(image, 0, 0, c);
//        return(bufferedImage);
//    }
    
//    public static boolean waitForImage(Image image, Component c) {
//        MediaTracker tracker = new MediaTracker(c);
//        tracker.addImage(image, 0);
//        try {
//        tracker.waitForAll();
//        } catch(InterruptedException ie) {}
//        return(!tracker.isErrorAny());
//    }
    
//    public static JFrame openInJFrame(Container content, int width, int height) {
//        return(openInJFrame(content, width, height, content.getClass().getName(), Color.white));
//    }
    
//    public static JFrame openInJFrame(Container content, int width, int height, String title, Color bgColor) {
//        JFrame frame = new JFrame(title);
//        frame.setBackground(bgColor);
//        content.setBackground(bgColor);
//        frame.setSize(width, height);
//        frame.setContentPane(content);
//        frame.addWindowListener(new ExitListener());
//        frame.setVisible(true);
//        return(frame);
//    }

    public void addBot(String alias, int x, int y) {
        bots.add(new WorldObject(x, y, alias));
        RectangleObject rec = new RectangleObject(x*rectSize + (rectSize/2), y*rectSize , rectSize/2, rectSize/2 );
        imagesBots.add(rec);
    }

    public void clean(String alias) {
        int botIndex = find(this.bots, alias);
        int dustIndex = findDust(this.dust, bots.get(botIndex).getXpos(), bots.get(botIndex).getYpos());
        if(dustIndex!=-1){
            dust.remove(dustIndex);
            imagesDust.remove(dustIndex);
        }
    }

    public void move(String alias, int x, int y) {
        int botIndex = find(this.bots, alias);
        bots.get(botIndex).setXpos(x);
        bots.get(botIndex).setYpos(y);
        if(botIndex!=-1){
            RectangleObject rec = new RectangleObject(x*rectSize + (rectSize/2), y*rectSize , rectSize/2, rectSize/2 );
            imagesBots.set(botIndex, rec);
        }
        
    }

    private int find(List<WorldObject> bots, String alias) {
        for (int i = 0; i < bots.size(); i++) {
            if(bots.get(i).getAlias().equals(alias)){
                return i;
            }
        }
        return -1;
    }

    
    private int findDust(List<WorldObject> dust, int xpos, int ypos) {
        
        for (int i = 0; i < dust.size(); i++) {
            if(xpos == dust.get(i).getXpos() && ypos == dust.get(i).getYpos()){        
                return i;
            }
        }
        return -1;
    }
    
//    public static class ExitListener extends WindowAdapter {
//        @Override
//        public void windowClosing(WindowEvent event) {
//            System.exit(0);
//        }
//    }

    public List<WorldObject> getBots() {
        return bots;
    }

    public void setBots(List<WorldObject> bots) {
        this.bots = bots;
    }

    public List<WorldObject> getDust() {
        return dust;
    }

    public void setDust(List<WorldObject> dust) {
        this.dust = dust;
    }    
    
}


