package tt;
import tt.Obstacle;
import tt.Personnage;
import tt.Fruit;

import java.util.ArrayList;

public class depV1 {
	
	static Fruit fruit1 = new Fruit(3,3);
	static Fruit fruit2 = new Fruit(5,2);
	static Obstacle Obstacle1 = new Obstacle(2,1);
	static Obstacle Obstacle2 = new Obstacle(2,2);
	static Obstacle Obstacle3 = new Obstacle(2,3);
	static Obstacle Obstacle4 = new Obstacle(2,4);
	static ArrayList<Fruit> listeFruit = new ArrayList<Fruit>();
	static ArrayList<Obstacle> listeObstacle = new ArrayList<Obstacle>();

	public static void main(String[] args) {
		
		//String plateau = "0_4_13:13,XXXXXXXXXXXXX,X......01...X,X...XX.XX...X,X.X......4X.X,X1X.......X1X,X.....3.....X,X...0...2...X,X0....3....0X,X1X.......X.X,X.X4.....4X.X,X...XX.XX...X,X...10.0....X,XXXXXXXXXXXXX_Equipe0,P,P0:3:5:4,P1:5:1:x,P2:4:6:2,Z,Z0:2:1,Z1:1:1,Z2:1:2,G,2,F,F0:1,F1:1,F2:0,F3:0,F4:0_Equipe1,P,P0:8:11:x,P1:9:8:x,P2:11:8:x,Z,Z0:11:10,Z1:11:11,Z2:10:11,G,2,F,F0:0,F1:2,F2:0,F3:0,F4:1_Equipe2,P,P0:1:11:x,P1:4:11:x,P2:3:8:x,Z,Z0:2:11,Z1:1:10,Z2:1:11,G,-3,F,F 0:0,F1:0,F2:0,F3:0,F4:2_Equipe3,P,P0:11:5:0,P1:7:5:x,P2:10:1:x,Z,Z0:11:1,Z1:10:1,Z2:11:2,G, 0,F,F0:0,F1:0,F2:0,F3:0,F4:";
		
		listeObstacle.add(Obstacle1);
		listeObstacle.add(Obstacle2);
		listeObstacle.add(Obstacle3);
		listeObstacle.add(Obstacle4);
		listeFruit.add(fruit1);
		listeFruit.add(fruit2);
		/*
		Obstacle Obstacle00 = new Obstacle(0,0);
		Obstacle Obstacle01 = new Obstacle(0,1);
		Obstacle Obstacle02 = new Obstacle(0,2);
		Obstacle Obstacle03 = new Obstacle(0,3);
		Obstacle Obstacle04 = new Obstacle(0,4);
		Obstacle Obstacle05 = new Obstacle(0,5);
		Obstacle Obstacle06 = new Obstacle(0,6);
		Obstacle Obstacle10 = new Obstacle(1,0);
		Obstacle Obstacle20 = new Obstacle(2,0);
		Obstacle Obstacle30 = new Obstacle(3,0);
		Obstacle Obstacle40 = new Obstacle(4,0);
		Obstacle Obstacle50 = new Obstacle(5,0);
		Obstacle Obstacle60 = new Obstacle(6,0);
		Obstacle Obstacle61 = new Obstacle(6,1);
		Obstacle Obstacle62 = new Obstacle(6,2);
		Obstacle Obstacle63 = new Obstacle(6,3);
		Obstacle Obstacle64 = new Obstacle(6,4);
		Obstacle Obstacle65 = new Obstacle(6,5);
		Obstacle Obstacle66 = new Obstacle(6,6);
		Obstacle Obstacle16 = new Obstacle(1,6);
		Obstacle Obstacle26 = new Obstacle(2,6);
		Obstacle Obstacle36 = new Obstacle(3,6);
		Obstacle Obstacle46 = new Obstacle(4,6);
		Obstacle Obstacle56 = new Obstacle(5,6);*/
		
		Personnage personnage1 = new Personnage(1,3);

		System.out.println("lancement recherche");
		trajetAller(personnage1, listeFruit);

	}
	
	public static ArrayList<ArrayList<Case>> trajetAller( Personnage p1, ArrayList<Fruit> fruits ){

		ArrayList<ArrayList<Case>> listeChemin = new ArrayList<ArrayList<Case>>();
		
		for( Fruit f : fruits ) {

			ArrayList<Case> chemin = new ArrayList<Case>();
			
			int nx = p1.x;
			int ny = p1.y;
			
			while( nx != f.x || ny != f.y ){
				
				if( nx < f.x ){ // personnage à gauche du fruit
					
					for( Obstacle m : listeObstacle ){
						int nnx = nx + 1;
						if( nnx == m.x) {
							if(ny == m.y ){ // obstacle juste à droite
							
							if( nnx == m.x) {
								int nny = ny + 1;
								int nmy = m.y - 1;
								if( nny == nmy ){ // obstacle au dessus à droite
							
										ny--;
										Case newCase = new Case(nx,ny);
										chemin.add(newCase);
							
								}
							
							}
						}
						}
						else {
							
							nx++;
							Case newCase = new Case(nx,ny);
							chemin.add(newCase);
						}
					}
					
					}
				
				else if( nx > f.x ){	// personnage à droite du fruit
					
					for( Obstacle m : listeObstacle ){
						
						if( nx-1 == m.x && ny == m.y ){ // obstacle juste à gauche
							int nmx = m.x - 1;
							int nmy = m.y -1;
							if( nx-1 == nmx && ny-1 == nmy ){ // obstacle au dessus à gauche
								
								ny++;
								Case newCase = new Case(nx,ny);
								chemin.add(newCase);
							}
						}
						else {
							
							nx--;
							Case newCase = new Case(nx,ny);
							chemin.add(newCase);
						}
					}
				}
				
				else if( ny < f.y ){	// personnage au dessus du fruit
					
					for( Obstacle m : listeObstacle ){

						System.out.println("Analyse d'un obstacle");
						if( nx == m.x && ny+1 == m.y ){ // obstacle juste en dessous
							int nmx = m.x +1;
							int nmy = m.y + 1;
							if( nx+1 == nmx && ny+1 == nmy ){ // obstacle en dessous à droite
								
								nx--;
								Case newCase = new Case(nx,ny);
								chemin.add(newCase);
							}
						}
						else {
							
							ny++;
							Case newCase = new Case(nx,ny);
							chemin.add(newCase);
						}
					}
				}
				
				else if( ny > f.y ){	// personnage en dessous du fruit
					
					for( Obstacle m : listeObstacle ){
						
						if( nx == m.x && ny-1 == m.y ){ // obstacle juste au dessus
							
							if( nx+1 == m.x && ny-1 == m.y ){ // obstacle au dessus à droite
								
								nx--;
								Case newCase = new Case(nx,ny);
								chemin.add(newCase);
							}
						}
						else {
							
							ny--;
							Case newCase = new Case(nx,ny);
							chemin.add(newCase);
						}
					}
				}
			}
			
		listeChemin.add(chemin);
		
		System.out.println(nx);
		System.out.println(ny);
		}

		System.out.println(listeChemin);
		return listeChemin;
	}
	
	public static void trajetRetour( Personnage p1, Fruit f1 ) {
		
	}

}
