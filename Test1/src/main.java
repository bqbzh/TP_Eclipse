import java.util.*;

public class main {
	
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
		/*for(int i = 128; i<256; i++){
			for(int j = 128; j<256; j++){
				n.setPixel(i, j, 128);				
			}
		}
		// on sauve l'image
		n.saveAsPng("./test.png");
				*/
		//on charge une image
		ImageTraitement lena = new ImageTraitement("./src/lena.pgm");
		lena.show();
		ImageTraitement histo = new ImageTraitement(300,500);
		histo = lena.histogramme();
		histo.show();
		//int[] pixels = lena.getPixel(0, 0);
		//System.out.println(pixels[0]+" "+pixels[1]+" "+pixels[2]+" "+pixels[3]);
	}
}
