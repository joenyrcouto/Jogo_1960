import java.io.IOException;
import java.text.Normalizer;
import java.util.regex.Pattern;
import java.util.Random;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) throws IOException, InterruptedException {
			Scanner Sc = new Scanner(System.in);
			String quebra = System.getProperty("line.separator");
			
			int mapa[][] = {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,0,0,0,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,1,1,0,0,0,1,1},{1,1,1,0,0,0,3,0,0,0,0,1,1,1,0,4,0,0,0,0,1,1,1,1,1,0,5,0,1,1},{1,1,1,0,1,0,0,0,1,1,0,0,0,1,0,0,0,1,1,0,1,1,15,1,1,0,0,0,1,1},{1,1,1,0,1,1,0,1,1,1,0,1,0,1,1,1,1,1,0,0,1,1,0,0,0,0,1,1,1,1},{1,1,1,0,0,1,0,0,12,1,0,1,1,1,1,0,0,0,0,1,1,1,0,1,1,1,1,1,1,1}, {1,1,1,1,0,1,1,0,1,1,0,1,1,1,1,1,1,0,1,1,1,1,0,0,0,1,1,18,1,1},{1,1,1,0,0,0,1,0,1,1,0,1,1,1,0,0,0,0,1,1,1,1,1,1,0,1,0,0,1,1},{1,1,1,0,1,0,0,0,0,0,0,0,0,1,0,1,1,1,1,1,1,1,1,1,0,1,0,1,1,1},{1,1,0,0,1,0,1,0,1,1,1,1,0,1,0,1,0,0,0,0,1,1,0,0,0,0,0,1,1,1},{1,1,0,1,1,1,1,0,1,0,0,0,0,1,0,1,0,1,0,0,0,1,0,1,1,1,1,1,1,1},{1,1,0,0,0,1,1,0,1,0,1,1,1,1,0,1,0,0,0,1,0,0,0,1,0,0,0,1,1,1},{1,1,0,6,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,13,0,1,1,1,0,7,0,1,1,1},{1,1,0,0,0,1,1,0,1,1,1,1,1,0,19,0,0,0,1,1,0,1,1,0,0,0,0,1,1,1},{1,1,1,1,1,1,11,0,1,1,1,1,1,0,0,21,1,1,1,0,0,1,1,0,1,1,1,1,1,1},{1,1,1,1,1,1,1,0,1,1,1,1,1,1,0,1,1,0,0,0,1,1,0,0,0,1,0,1,1,1},{1,1,0,0,0,1,0,0,1,16,0,0,0,0,0,0,1,0,1,1,1,1,0,1,1,1,0,1,1,1},{1,1,0,1,0,0,0,1,1,1,0,1,0,1,1,0,1,0,0,0,0,0,0,0,1,1,0,1,1,1},{1,1,1,1,0,1,0,0,0,0,0,1,0,0,1,0,1,1,1,1,1,1,1,0,0,0,0,1,1,1},{1,1,1,0,0,1,1,1,0,1,1,1,1,0,0,0,0,0,0,0,0,1,1,0,1,0,1,1,1,1},{1,1,1,1,1,1,1,0,0,1,1,1,1,0,1,1,1,0,1,1,0,0,0,0,1,0,1,1,1,1},{1,1,0,0,0,1,1,0,1,1,1,1,0,0,0,1,1,1,1,1,0,1,14,1,0,0,0,1,1,1},{1,1,0,8,0,17,0,0,1,1,1,1,0,9,0,1,1,1,0,0,0,1,1,1,0,10,0,1,1,1},{1,1,0,0,0,1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}}, t, i, x=15, y=14, Vx=(x-2), Vy=(y-2), VY=(y+3), VX=(x+3), chat = 0, M, orientacao = 0, solve = 0, damage = 0, inv[] = new int[5], Pinv = 0, perigo=0, kill=0, forcaacerto = 0, enigmasresolvidos = 0, quadrosvistos[] = {0, 0, 0, 0, 0, 0}, quantidadedequadrosvistos = 0;
			boolean T = true, O = true, G = true, N = false,  Inv = false, lanterna = true, forca = true, mapahack = false, pedidodechave = false, inventariocheio = false;
			String input="null", textura[] = new String[25], palavrafinal[] = new String[8], nomeitem="null", palavradoforca[] = {"h", "o", "r", "r", "e", "n", "d", "o"}, palavradoforcar[] = {"∆", "∆", "∆", "∆", "∆", "∆", "∆", "∆"};
			
			// preencher string da word final
			for(t=0; t<8; t++)
				palavrafinal[t] = "∆";
			
			// textura //
			textura[0] = "   "; // vazio
			textura[1] = "###"; // parede 
			textura[2] = " 0 "; //personagem
			textura[3] = " * "; // enigima 1
			textura[4] = " * "; // enigima 2
			textura[5] = " * "; // enigima 3
			textura[6] = " * "; // enigima 4
			textura[7] = " * "; // enigima 5
			textura[8] = " * "; // enigima 6
			textura[9] = " * "; // enigima 7
			textura[10] = " * "; // enigima 8
			textura[11] = " + "; // detalhe de mapa 1
			textura[12] = " + "; // detalhe de mapa 2
			textura[13] = " + "; // detalhe de mapa 3
			textura[14] = " + "; // detalhe de mapa 4
			textura[15] = " + "; // detalhe de mapa 5
			textura[16] = " + "; // detalhe de mapa 6
			textura[17] = "###"; // parede decaida 1
			textura[18] = "###"; // parede decaida 2
			textura[19] = " @ "; // bau
			textura[20] = " • "; // chave
			textura[21] = " ! "; // lanterna
			textura[22] = " Z "; // pedindo chave
			textura[23] = " / "; // carta
			textura[24] = " / "; // carta
			
			// while principal //
			while(G){
			
			// while de menu //
			while(O){
			System.out.print("\033[H\033[2J");
limpatela();
			System.out.print("  .  .-.    ,  .-. "+quebra+".'| (   )  /  :   :"+quebra+"  |  `-/  /-. |   |"+quebra+"  |   /  (   ):   ;"+quebra+"'---''    `-'  `-'"+quebra+quebra+"1 - jogar"+quebra+"2 - como jogar"+quebra+"3 - creditos"+quebra+"4 - sair"+quebra+quebra+"input: ");
			input = Sc.nextLine();
			
			switch(input){
				case "1":{
					O = false;
					T = true;}
					break;
					
				case "2":{
					while(O){
						System.out.print("\033[H\033[2J");
limpatela();
						System.out.print("------------------------ [premissa] ------------------------"+quebra+"Voce esta numa empresa abandonada, e seu objetivo e explora-la a fim de conhecer a sua historia por ali deixada. Nela ha objetos para interagir, para isso e nescessario que voce va em sua direcao, estes estao bem destacados pelo mapa. E tenha cuidado com a escuridao."+quebra+quebra+"------------------------- [niveis] -------------------------"+quebra+quebra+"[Nivel facil]: estes sao os que devem ser primeiro resolvidos, simples e sem associacoes."+quebra+quebra+"[Nivel medio]: Meio termo entre os outros niveis, nao e trabalhoso, e nem tem dados especificos."+quebra+quebra+"[Nivel extremo]: relacionados com dados da historia do game, ou trabalhosos."+quebra+quebra+"-------------------- [opcoes de input] ---------------------"+quebra+quebra+"[M]: voltar ao menu."+quebra+"[NIVEL]: este quando utilizado em enigmas, mostrara o nivel do mesmo."+quebra+"[I]: Abrir/fechar inventario."+quebra+"[U]: usar item."+quebra+"[W, A, S, D]: Teclas padrao de movimentacao."+quebra+"[1, 2, 3, 4, 5]: opcoes do inventario."+quebra+"[EW, EA, ES, ED]: teclas para dropar item."+quebra+quebra+"input(4 - sair): ");
					input = Sc.nextLine();
					
					if(input.equals("4"))
						O = false;}
					O = true;}
					break;
					
				case "3":{
					while(O){
						System.out.print("\033[H\033[2J");
limpatela();
							System.out.print("Powered by Joenyr Couto, Raphael Mota, Paulo Tanine and Willyans Chen - 2022"+quebra+quebra+"input(4 - sair): ");	
					input = Sc.nextLine().toLowerCase();
					
					if(input.equals("4"))
						O = false;}
						O = true;}
					break;
					
					case "4":{
						O = false;
						T = false;
						G = false;
						System.out.print("\033[H\033[2J");
limpatela();}}}
			
			// while do jogo //
			while(T){
			System.out.print("\033[H\033[2J");
limpatela();
				
			// localizacao do personagem //
			mapa[x][y] = 2;
			
			if(chat == 17 && damage==2)
				mapa[23][5] = 0;
			if(chat == 18 && damage==2)
				mapa[7][27] = 20;
				
			// acoes de rapida sem chat //
			if(chat == 24 || chat == 23 || chat == 21 || chat == 20)
						if(inv[Pinv] == 0){
						inv[Pinv] = chat;
						switch(input){
							case "w":
										mapa[x-1][y] = 0;
								break;
								
							case "a":
										mapa[x][y-1] = 0;
								break;
									
							case "s":
										mapa[x+1][y] = 0;
								break;
								
							case "d":
										mapa[x][y+1] = 0;
								break;}}
						else
							inventariocheio = true;
					
			// visao do personagem e gatilho //
			if(mapahack){
				Vx = 0; Vy = 0; VX = 27; VY = 30;}
			else{
				if(inv[Pinv] == 21 && lanterna){
					Vx = x-2; Vy = y-2; VX = x+3; VY = y+3;
					perigo = 0;}
				else{
					Vx = x-1; Vy = y-1; VY = y+2; VX = x+2;
					perigo++;
					if(perigo==7){
						G = false;
						T = false;
						System.out.print("voce foi descuidado, e morreu. :(");}}}
					
			// imprimir info e mapa //	
			while(chat!=0 && chat!=17 && chat!=18 && T){
				if(chat<11 || chat>16){
				for(t=(Vx); t<(VX); t++){
				for(i=(Vy); i<(VY); i++)
					System.out.print(textura[mapa[t][i]]);
			System.out.print(quebra);}}
				switch(chat){
					case 3:{
						if(N)
							System.out.println("[Nivel facil]");
						System.out.print("De um lado um amor em ruinas, do outro meu em ascensao, inicio na casa das sem caminho, das sem direcao.");}
						break;
						
					case 4:{
						if(N)
							System.out.println("[Nivel facil]");
						System.out.print("Do meu novo amor emergido, nova duvida se estabelece, do trabalho profissional isso se esclarece.");}
						break;
						
					case 5:{
						if(N)
							System.out.println("[Nivel extremo]");
						System.out.print("Um marco, no periodo eu tive, da minha propria justica, o fim de uma vida de ira.");}
						break;
						
					case 6:{
						if(N)
							System.out.println("[Nivel facil]");
						System.out.print("-- .- --. -. .- - .-");}
						break;
						
					case 7:{
						if(N)
							System.out.println("[Nivel medio]");
						System.out.print("Um ato ao amor, extremo, a todos eu fremi, assim da ferramenta foi tao claro que deu pro mundo ouvir.");}
						break;
						
					case 8:{
						if(N)
							System.out.println("[Nivel medio]");
						System.out.print("Todos temos por onde sermos despreziveis. Para o mal que a alma lhe pede.");}
						break;
					
					case 9:{
						if(N)
							System.out.println("[Nivel extremo]");
						System.out.print("0:54=UxM5UgpXYM4");}
						break;
						
					case 10:{
						if(N)
							System.out.println("[Nivel medio]");
						System.out.print("Da liberdade ao pequeno e apertado lugar, hoje aqui permaneco esperando a me julgar.");}
						break;
						
					case 11:{
						System.out.print("0000000000000000000011111111111100000000"+quebra+"0000000000000000001111111111111111100000"+quebra+"0000000000000000111110000000001111111000"+quebra+"0000000000000001111000000000000001111100"+quebra+"0000000000000011110000000000000000011110"+quebra+"0000000000000011100000000000000000001110"+quebra+"0000000000000011100000000000000000001110"+quebra+"0000000000000011110000000000000000001110"+quebra+"0000000000000001111100000000000000111100"+quebra+"0000000000000000111111100000000111111000"+quebra+"0000000000000011111111111111111111110000"+quebra+"0000000000001111111011111111111110000000"+quebra+"0000000000111111100000000000000000000000"+quebra+"0000000011111110000000000000000000000000"+quebra+"0000001111111000000000000000000000000000"+quebra+"0000111111110000000000000000000000000000"+quebra+"0011111111000000000000000000000000000000"+quebra+"0111111100000000000000000000000000000000"+quebra+"0111110000000000000000000000000000000000");
						quadrosvistos[0] = 1;}
						break;
						
					case 12:{
						System.out.print("0000000000000000000000000000000000000000"+quebra+"0000022222222222000000000222222222200000"+quebra+"0002221111111177222000021111111117122000"+quebra+"0021122222211111172202212222221111177200"+quebra+"0211222222211111112022122222211111117720"+quebra+"0211222221111111120211122211111111117720"+quebra+"0211222111111111202111111111111111117720"+quebra+"0211122111111112002111111111111111117720"+quebra+"0021111111111117220221111111111111177200"+quebra+"0002111111111111772202211111111111772000"+quebra+"0000221111111111117200211111111117720000"+quebra+"0000022111111111112002111111111772200000"+quebra+"0000000221111111220221111111117220000000"+quebra+"0000000002211111200211111111722000000000"+quebra+"0000000000022111720211111112200000000000"+quebra+"0000000000000222172021111220000000000000"+quebra+"0000000000000002222021222000000000000000"+quebra+"0000000000000000000002000000000000000000");
						quadrosvistos[1] = 1;}
						break;
						
					case 13:{
						System.out.print("0000000000000000001111100000000000000000"+quebra+"0000000000000000011111100000000000000000"+quebra+"0000000000001111111111111110000000000000"+quebra+"0000000000111111111111111111100000000000"+quebra+"0000000001111111111111111111110000000000"+quebra+"0000000001111111011111101111111000000000"+quebra+"0000000001111110011111101111111000000000"+quebra+"0000000001111111111111100011100000000000"+quebra+"0000000000111111111111110000000000000000"+quebra+"0000000000011111111111111110000000000000"+quebra+"0000000000000001111111111111110000000000"+quebra+"0000000000111000011111111111111000000000"+quebra+"0000000001111110011111101111111000000000"+quebra+"0000000001111111001111100111111000000000"+quebra+"0000000001111111111111111111110000000000"+quebra+"0000000000011111111111111111100000000000"+quebra+"0000000000000111111111111110000000000000"+quebra+"0000000000000000011111100000000000000000"+quebra+"0000000000000000001111100000000000000000");
						quadrosvistos[2] = 1;}
						break;
						
					case 14:{
						System.out.print("00000000000000000000000000000000000000000000000000"+quebra+"00000000000000000000000000000000000000000000000000"+quebra+"00000000000000000000000000000000000000000000000000"+quebra+"00000000000000000000000000000000000000000000000000"+quebra+"00000000000000000000011111000000000000000000000000"+quebra+"00000000000000000000111111111100000000000000000000"+quebra+"00000000000000000001111111111110000000000000000000"+quebra+"00000000000000000011111111111110000000000000000000"+quebra+"00000000000000000111111111110000000000000000000000"+quebra+"00000000000000001111111111111100000000000000000000"+quebra+"00000000000000111111111111111111110000000000000000"+quebra+"00000000000001111111111110111111111111000000000000"+quebra+"00000000000001111111111100000111111111111100000000"+quebra+"00000000000000000111111100000000011111111111000000"+quebra+"00000000000000000000011000000000000001111111000000"+quebra+"00000000000000000000000000000000000000000110000000"+quebra+"00000000000000000000000000000000000000000000000000"+quebra+"00000001111111111111111111000000000000000000000000"+quebra+"00000011111111111111111111110000000000000000000000"+quebra+"00000111111111111111111111110000000000000000000000"+quebra+"00000011111111111111111111100000000000000000000000"+quebra+"00000000000000000000000000000000000000000000000000"+quebra+"00000000000000000000000000000000000000000000000000"+quebra+"00000000000000000000000000000000000000000000000000");
						quadrosvistos[3] = 1;}
						break;
						
					case 15:{
						System.out.print("000000000000000000000000000000000000000000000000"+quebra+"000000000000000000000000000000000000000000000000"+quebra+"000000000000000000000000000000000000000000000000"+quebra+"000000000000000000000001100000000000000000000000"+quebra+"000000000000000000000011110000000000000000000000"+quebra+"000000000000111111111111111111111111100000000000"+quebra+"000000000011111111111111111111111111110000000000"+quebra+"000000000001111111111111111111111111100000000000"+quebra+"000000000011111000000011110000001111100000000000"+quebra+"000000000011111100000011110000001111100000000000"+quebra+"000000000011011100000011110000001101110000000000"+quebra+"000000000111001110000011110000011100111000000000"+quebra+"000000000111001110000011110000011100111000000000"+quebra+"000000001111111111000011110000111111111100000000"+quebra+"000000000111111110000011110000011111111000000000"+quebra+"000000000000000000000011110000000000000000000000"+quebra+"000000000000000000000011110000000000000000000000"+quebra+"000000000000001111111111111111111100000000000000"+quebra+"000000000000001111111111111111111100000000000000"+quebra+"000000000000001111111111111111111100000000000000"+quebra+"000000000000000000000000000000000000000000000000"+quebra+"000000000000000000000000000000000000000000000000"+quebra+"000000000000000000000000000000000000000000000000");
						quadrosvistos[4] = 1;}
						break;
						
					case 16:{
						System.out.print("0000000000000000000011111111111111000000"+quebra+"0000000000000000000111111111111111111100"+quebra+"0000000000000000000111111111111111111111"+quebra+"0000000111111111111111111111111111111111"+quebra+"0000011111111111111111111111111111111111"+quebra+"0000111111111111111111111111111111111111"+quebra+"0000111111111111111111111111111111111100"+quebra+"0001111111111111111111111111111111110000"+quebra+"0011111111111111111111111111111111111000"+quebra+"0011111111111111111111111111111111111100"+quebra+"0011111111111111111111111111111111111100"+quebra+"0011111111111111111111111111111111111100"+quebra+"0011111111111111111111111111111111111100"+quebra+"0111111111111111111111111111111111111000"+quebra+"1111111111111111111111111111111111110000"+quebra+"1111111111111111111111111111111111100000"+quebra+"0011111111111111111111111111111110000000"+quebra+"0011111111111111111111111111111000000000"+quebra+"0011111111111111111111111111110000000000"+quebra+"0001111111111111111111111111110000000000"+quebra+"0000111111111111111111111111111000000000"+quebra+"0000000000000000111111111111111000000000"+quebra+"0000000000000000111111111111111100000000"+quebra+"0000000000000000011111111111111100000000"+quebra+"0000000000000000011111111111111110000000"+quebra+"0000000000000000011111111111111111000000"+quebra+"0000000000000000011111111111111111100000"+quebra+"0000000000000000111111111111110000000000"+quebra+"0000000000000000111111111110000000000000"+quebra+"0000000000000001111111111000000000000000"+quebra+"0000000000000011111111100000000000000000");
						quadrosvistos[5] = 1;}
				break;
					
					case 19:{
						solve = 0;
						for(t=0; t<8; t++){
							if (palavrafinal[t].equals("∆"))
								System.out.print("_ ");
							else{
								System.out.print(palavrafinal[t]+" ");
								solve++;}}
							if(solve == 8)
								System.out.print(" [bau destrancado]");
							else
								System.out.print(" [bau trancado]");}
						break;
							
					case 22:{
						if(inv[Pinv] == 20){
							mapa[14][14] = 23;}
						else
							pedidodechave = true;}
					break;}
						
						if(chat != 20 && chat != 21 && chat != 22 && chat != 23 && chat != 24){
							System.out.print(quebra+quebra+"input(4 - sair): ");
							input = Sc.nextLine().toLowerCase();}
						else
							input = "4";
						
						switch(deAccent(input)){
							case "4":
								chat = 0;
							break;
							
							case "infidelidade":
								if(chat == 3){
									palavrafinal[0] = "c";
									textura[3] = " x ";
									chat = 0;}
								break;
								
							case "detetive":
								if(chat == 4){
									palavrafinal[1] = "a";
									textura[4] = " x ";
									chat = 0;}
								break;
									
							case "2012":
								if(chat == 5){
									palavrafinal[2] = "s";
									textura[5] = " x ";
									chat = 0;}
								break;
								
							case "magnata":
								if(chat == 6){
									palavrafinal[3] = "o";
									textura[6] = " x ";
									chat = 0;}
								break;
								
							case "revolver":
								if(chat == 7){
									palavrafinal[4] = "y";
									textura[7] = " x ";
									chat = 0;}
								break;
									
							case "crime":
								if(chat == 8){
									palavrafinal[5] = "o";
									textura[8] = " x ";
									chat = 0;}
								break;
									
							case "ninguem esta naquele lugar":
								if(chat == 9){
									palavrafinal[6] = "k";
									textura[9] = " x ";
									chat = 0;}
								break;
									
								case "tribunal":
									if(chat == 10){
										palavrafinal[7] = "i";
										textura[10] = " x ";
										chat = 0;}
									break;
										
								case "nivel":{
									if(N)
										N = false;
									else
										N = true;}}
						System.out.print("\033[H\033[2J");
limpatela();}
			
			if(enigmasresolvidos == 0){
				quantidadedequadrosvistos = 0;
				for(t=0; t<6; t++)
					quantidadedequadrosvistos += quadrosvistos[t];
					if(quantidadedequadrosvistos == 6)
						enigmasresolvidos = 1;}
			
			if(N)
				N = false;
			if(T){
				if(pedidodechave)
					System.out.println("*capsula de pergaminho trancada a chave*");
				if(inventariocheio)
					System.out.println("*bolso cheio*");
				if(enigmasresolvidos == 1){
					System.out.println("Yoshizo Kitano");
					enigmasresolvidos = 2;}
				for(t=(Vx); t<(VX); t++){
				for(i=(Vy); i<(VY); i++)
					System.out.print(textura[mapa[t][i]]);
			System.out.print(quebra);}
				pedidodechave = false;
				inventariocheio = false;}
			
			// invetario //
			if(Inv && T){
				switch(inv[Pinv]){
					case 20:
						nomeitem = "chave";
						break;
					
					case 21:
						nomeitem = "lanterna";
						break;
						
					case 23:
						nomeitem = "carta";
						break;
						
					case 24:
						nomeitem = "carta fake";
						break;}
				if(inv[Pinv] != 20 && inv[Pinv] != 21 && inv[Pinv] != 23 && inv[Pinv] != 24)
					nomeitem = "null";
				switch(Pinv){
					case 0:
				System.out.print("[ ("+textura[inv[0]]+") | "+textura[inv[1]]+" | "+textura[inv[2]]+" | "+textura[inv[3]]+" | "+textura[inv[4]]+"]");
					break;
					
					case 1:
				System.out.print("["+textura[inv[0]]+"| ("+textura[inv[1]]+") | "+textura[inv[2]]+" | "+textura[inv[3]]+" | "+textura[inv[4]]+"]");
					break;
					
					case 2:
				System.out.print("["+textura[inv[0]]+" | "+ textura[inv[1]]+"| ("+textura[inv[2]]+") | "+textura[inv[3]]+" | "+textura[inv[4]]+"]");
					break;
					
					case 3:
				System.out.print("["+textura[inv[0]]+" | "+ textura[inv[1]]+" | "+textura[inv[2]]+"| ("+textura[inv[3]]+") | "+textura[inv[4]]+"]");
					break;
					
					case 4:
				System.out.print("["+textura[inv[0]]+" | "+ textura[inv[1]]+" | "+textura[inv[2]]+" | "+textura[inv[3]]+"| ("+textura[inv[4]]+") ]");
					break;}
					if(inv[Pinv] == 21){
						if(lanterna)
							System.out.println(" ["+nomeitem+"]"+"[on]");
						else
							System.out.println(" ["+nomeitem+"]"+"[off]");}
					else
						System.out.println(" ["+nomeitem+"]");}
			
			// acoes da parede especial //
			if(chat == 17){
				switch(damage){
						case 0:{
							System.out.print("parece que essa parede esta solta...");
							damage++;}
							break;
							
						case 1:{
							System.out.print("talvez se eu empurrar-la...");
							damage++;}
							break;
						case 2:{
							System.out.print("*troomm*");
							damage=0;}}
				System.out.println(quebra);
				chat = 0;}
				
				if(chat == 18){
				switch(damage){
						case 0:{
							System.out.print("esta parede esta quase caindo...");
							damage++;}
							break;
							
						case 1:{
							System.out.print("Sera se eu encontro algo por aqui?");
							damage++;}
							break;
						case 2:{
							System.out.print("wow!!");
							damage=0;}}
				System.out.println(quebra);
				chat = 0;}
				
			if(damage <=2 && mapa[23][6] == 0 && mapa[8][27] == 0)
				damage = 0;
			
			// captura de input //
			if (T){
			System.out.print("navegue por awsd: ");
			input = Sc.nextLine().toLowerCase();}
			
			// inteiro verificador de movimento //
			M = x+y;
		
			// valores em //
			int Cima = mapa[x-1][y], Baixo = mapa[x+1][y], Direita = mapa[x][y+1], Esquerda = mapa[x][y-1]; 
		
			// acoes sobre o input //
			for(t=1; t<6; t++){
				if(input.equals(String.valueOf(t)))
					Pinv = t-1;}
			
			switch(input){
				case "finalhack":
					if(mapa[14][14] == 19 || mapa[14][14] == 22)
						mapa[14][14] = 24;
				break;
				case "mapahack":{
					if(mapahack)
						mapahack = false;
					else
						mapahack = true;}
					break;
						
				case "w":{
					orientacao = Cima;
					if(Cima == 0){
						x--;
						mapa[x+1][y] = 0;}}
					break;
						
				case "s":{
					orientacao = Baixo;
					if(Baixo == 0){
						x++;
						mapa[x-1][y] = 0;}}
					break;
					
				case "a":{
					orientacao = Esquerda;
					if(Esquerda == 0){
						y--;
						mapa[x][y+1] = 0;}}
						break;
					
				case "d":{
					orientacao = Direita;
					if(Direita == 0){	
						y++;
						mapa[x][y-1] = 0;}}
						break;
						
				case "m":{
					T = false;
					O = true;
					perigo--;}
					break;
					
				case "i":{
					if(Inv)
						Inv = false;
					else
						Inv = true;}
					break;
						
				case "ew":
					if(inv[Pinv] != 0 && mapa[x-1][y] == 0){
							mapa[x-1][y] = inv[Pinv];
							inv[Pinv] = 0;}
					break;
				
				case "ea":
					if(inv[Pinv] != 0 && mapa[x][y-1] == 0){
						mapa[x][y-1] = inv[Pinv];
						inv[Pinv] = 0;}
					break;
						
				case "es":
					if(inv[Pinv] != 0 & mapa[x+1][y] == 0){
						mapa[x+1][y] = inv[Pinv];
						inv[Pinv] = 0;}
					break;
						
				case "ed":
					if(inv[Pinv] != 0 && mapa[x][y+1] == 0){
						mapa[x][y+1] = inv[Pinv];
						inv[Pinv] = 0;}
					break;
					
				case "u":
					switch(inv[Pinv]){
						case 23:{
							while(G){
								System.out.print("\033[H\033[2J");
								limpatela();
								System.out.print("Minha amada filha, trago essa carta para com"+quebra+quebra+"não foi fácil escrever, período de grande perturbação, e retalhação na empresa, e sumiço do administrador."+quebra+quebra+"Infelizmente, digo que houve desativação permanente do edifício, por incidências de acontecimentos desastrosos, além do mais."+quebra+quebra+"Me sinto horrível o fato de ter que escrever isto, principalmente por como as coisas chegaram nesse ponto, já há uma decadência e cicatriz incurável nesta empresa."+quebra+quebra+"Não sei quando você lerá essa carta ou se um dia isso irá acontecer. Sei o quão complicada é nossa história, mas o que eu escrevo aqui não se apagará tão fácil."+quebra+quebra+"- [autor desconhecido], 19/05/2012."+quebra+quebra+"input(4 - sair): ");
								input = Sc.nextLine();
								if(input.equals("4"))
									G = false;}
									G = true;}
									break;
									
						case 24:{
							while(G){
								System.out.print("\033[H\033[2J");
								limpatela();
								System.out.print("*carta em branco, final antecipado*"+quebra+quebra+"input(4 - sair): ");
								input = Sc.nextLine();
								if(input.equals("4"))
									G = false;}
									G = true;}
									break;
									
							case 21:{
								if(lanterna)
									lanterna = false;
								else
									lanterna = true;}}}
			
			// forca
			if(input.equals("yoshizo kitano") && forca){
				while(forca){
				System.out.print("\033[H\033[2J");
limpatela();
				if(N)
					System.out.println("[Nivel desconhecido]");
				System.out.print(",'+6$&$?  ");
						for(t=0; t<8; t++){
							if (palavradoforcar[t].equals("∆"))
								System.out.print("_ ");
							else
								System.out.print(palavradoforca[t]+" ");}
						System.out.print(" ["+(5-kill)+"]"+quebra+quebra+"input(4 - sair): ");
						

					input = Sc.nextLine().toLowerCase();
					if(input.equals("4"))
						forca = false;
					if(input.equals("nivel")){
						if(N)
							N = false;
						else
							N = true;}
						
					if(forca && !input.equals("nivel") && !input.equals("4")){
					for(t=0; t<8; t++){
						if(input.equals(palavradoforca[t])){
							if(!palavradoforcar[t].equals("x")){
								palavradoforcar[t] = "x";
								forcaacerto++;
							G = false;}
							else
								G = false;}}
					
					if(G)
							kill++;
						G = true;
					if(kill==5)
						forca = false;
					if(forcaacerto == 8)
						while(forca){
						System.out.print("\033[H\033[2J");
limpatela();
						System.out.print("As paredes do edificio estao frouxas, carta por clemencia a reforma! ou senao falencia da empresa. -Administrador"+quebra+quebra+"input(4 - sair): ");
						input = Sc.nextLine();
						
						if(input.equals("4"))
							forca = false;
							kill = 5;}}}
						if(kill<5)
							forca = true;
						N = false;}
			
			if (M == (x+y)){
			// interacao com ambiente, caso haja //
			for(t=3; t<11; t++)
				if(orientacao == t){
					if(palavrafinal[t-3].equals("∆"))
						chat = t;}
	
			for(t=11; t<25; t++)
				if(orientacao == t && t !=19)
					chat = t;
			if(orientacao == 19){
				if (solve != 8)
					chat = 19;
				else
					mapa[14][14] = 22;}
			}
			orientacao = 0;
			}}
}
// funcao de limpar linha //
public static void limpatela() throws IOException, InterruptedException{
        if (System.getProperty("os.name").contains("Windows"))
          new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");}
            
// funcao para tirar acentos //
public static String deAccent(String str) {
        String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD); 
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");}

}