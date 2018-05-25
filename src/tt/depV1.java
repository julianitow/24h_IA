package tt;
import tt.Mur;
import tt.Personnage;
import tt.Fruit;

import java.util.ArrayList;

public class depV1 {
	
	static Fruit fruit1 = new Fruit(3,5);
	static Fruit fruit2 = new Fruit(5,2);
	static ArrayList<Fruit> listeFruit = new ArrayList<Fruit>();

	public static void main(String[] args) {
		
		String plateau = "0_4_13:13,XXXXXXXXXXXXX,X......01...X,X...XX.XX...X,X.X......4X.X,X1X.......X1X,X.....3.....X,X...0...2...X,X0....3....0X,X1X.......X.X,X.X4.....4X.X,X...XX.XX...X,X...10.0....X,XXXXXXXXXXXXX_Equipe0,P,P0:3:5:4,P1:5:1:x,P2:4:6:2,Z,Z0:2:1,Z1:1:1,Z2:1:2,G,2,F,F0:1,F1:1,F2:0,F3:0,F4:0_Equipe1,P,P0:8:11:x,P1:9:8:x,P2:11:8:x,Z,Z0:11:10,Z1:11:11,Z2:10:11,G,2,F,F0:0,F1:2,F2:0,F3:0,F4:1_Equipe2,P,P0:1:11:x,P1:4:11:x,P2:3:8:x,Z,Z0:2:11,Z1:1:10,Z2:1:11,G,-3,F,F 0:0,F1:0,F2:0,F3:0,F4:2_Equipe3,P,P0:11:5:0,P1:7:5:x,P2:10:1:x,Z,Z0:11:1,Z1:10:1,Z2:11:2,G, 0,F,F0:0,F1:0,F2:0,F3:0,F4:";
		
		listeFruit.add(fruit1);
		listeFruit.add(fruit2);
		
		Mur mur00 = new Mur(0,0);
		Mur mur01 = new Mur(0,1);
		Mur mur02 = new Mur(0,2);
		Mur mur03 = new Mur(0,3);
		Mur mur04 = new Mur(0,4);
		Mur mur05 = new Mur(0,5);
		Mur mur06 = new Mur(0,6);
		Mur mur10 = new Mur(1,0);
		Mur mur20 = new Mur(2,0);
		Mur mur30 = new Mur(3,0);
		Mur mur40 = new Mur(4,0);
		Mur mur50 = new Mur(5,0);
		Mur mur60 = new Mur(6,0);
		Mur mur61 = new Mur(6,1);
		Mur mur62 = new Mur(6,2);
		Mur mur63 = new Mur(6,3);
		Mur mur64 = new Mur(6,4);
		Mur mur65 = new Mur(6,5);
		Mur mur66 = new Mur(6,6);
		Mur mur16 = new Mur(1,6);
		Mur mur26 = new Mur(2,6);
		Mur mur36 = new Mur(3,6);
		Mur mur46 = new Mur(4,6);
		Mur mur56 = new Mur(5,6);
		
		Personnage personnage1 = new Personnage(1,1);
		Fruit fruit1 = new Fruit(3,5);
			
		trajetAller(personnage1, fruit1);

	}
	
	public static void trajetAller( Personnage p1, Fruit f1 ){
		
		while( p1.x != f1.x && p1.y != f1.y ){
			
			if( p1.x < f1.x ){
				
				p1.x++;
			}
			else if( p1.x > f1.x ){
				
				p1.x--;
			}
			
			if( p1.y < f1.y ){
				
				p1.y++;
			}
			else if( p1.y > f1.y ){
				
				p1.y--;
			}
		}
		
		System.out.println(p1.x);
		System.out.println(p1.y);
		
	}
	
	public static void trajetRetour( Personnage p1, Fruit f1 ) {
		
		
	}

}
