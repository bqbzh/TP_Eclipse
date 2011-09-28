import java.awt.Color;
import ij.ImagePlus;
import ij.gui.NewImage;
import ij.io.FileSaver;
import ij.process.ImageProcessor;


/**
 * wrapper pour une image au sens de ImageJ
 *
 */
public class ImageTraitement {
	/**
	 * la veritable image
	 */
	private ImagePlus _image;
	
	
	/**
	 * creation d'une image vierge a partir de ses dimensions
	 * @param w largeur
	 * @param h hauteur
	 */
	public ImageTraitement(int w,int h) {
		_image = NewImage.createByteImage("test",w,h,1,NewImage.FILL_BLACK);
		_image.getProcessor().setColor(Color.WHITE);
	}

	/**
	 * creation d'une image a partir d'une image sur le disque en donnant son chemin d'acces.
	 */
	public ImageTraitement(String path){
		_image = new ImagePlus(path);
	}
	
	/**
	 * copie d'une image!
	 */
	public ImageTraitement(ImageTraitement image){
		_image=image._image;
	}
	/**
	 * accesseur
	 * @return la largeur de l'image
	 */
	public int getWidth() {
		return _image.getWidth();
	}
	
	/**
	 * accesseur
	 * @return la hauteur de l'image
	 */
	public int getHeight() {
		return _image.getHeight();
	}

	
	/**
	 * accesseur sur l'image interne (au sens d'ImageJ)
	 * @return
	 */
	private ImageProcessor getImageProcessor() {
		return _image.getProcessor();
	}
	
	/**
	 * "allume" le pixel de coordonnees (x,y) avec la valeur value.
	 * de points traces
	 * @param x
	 * @param y
	 */
	public void setPixel(int x,int y, int value) {
		byte[] pixels = (byte[]) _image.getProcessor().getPixels();
		pixels[y*_image.getWidth()+x] =  (byte)value;
	}
	
	/**
	 * permet d'obtenir les valeurs de chaque plan de couleur dans un tableau de dim 4 
	 * -les trois premieres valeurs R-G-B
	 * - pour une image en niveaux de gris, seul le premier element a une valeur
	 * @param x
	 * @param y
	 * @return
	 */
	public int[] getPixel(int x, int y){
		return _image.getPixel(x, y);
	}
	
	/**
	 * enregistre l'image construite au format PNG
	 * @param fileName le nom du fichier (doit contenir l'extension .png)
	 */
	public void saveAsPng(String fileName) {
		FileSaver fs = new FileSaver(_image);
		fs.saveAsPng(fileName);
	}
	
	/** 
	 * Affiche l'image
	 * 
	 */	
	public void show(){
		_image.show();
	}
	
	/**
	 * petit main simple pour construire une image 400x400, y tracer un pixel et sauver le resultat
	 * dans le fichier test.png
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/*ImageTraitement n = new ImageTraitement(400,400);
		System.out.println("dimensions : "+n.getWidth()+"x"+n.getHeight());
		//afficher l'image
		n.show();
		// mettre des pixels en niveau de gris
		for(int i = 128; i<256; i++){
			for(int j = 128; j<256; j++){
				n.setPixel(i, j, 128);				
			}
		}
		// on sauve l'image
		n.saveAsPng("./test.png");
		*/		
		
		//on charge une image
		ImageTraitement lena = new ImageTraitement("./lena.pgm");
		lena.show();
		
		//int[] pixels = lena.getPixel(0, 0);
		//System.out.println(pixels[0]+" "+pixels[1]+" "+pixels[2]+" "+pixels[3]);
		
	}
}
