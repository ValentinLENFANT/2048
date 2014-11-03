import java.lang.Math;
import java.util.Random;
import java.util.Scanner;

public class Projet2048 
	{
		
		
		//DEBUT DE LA DECLARATION DES VARIABLES GLOBALES
		
		int grille [][] = { {0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0} }; //Initialisation de la grille, à savoir un tableau à 2 dimensions
		Scanner saisie = new Scanner (System.in); //On instancie un objet permettant la saisie au clavier
		int score = 0;
		int nb1, nb2; //Ces deux variables vont nous permettre de nous déplacer dans le tableau, nb1 représentant les lignes et nb2 les colonnes
		int victoire, defaite = 0; //Variables permettant de déterminer si l'on a gagné ou perdu
		int choixfait = 0; //Variable permettant de déterminer si l'utilisateur a choisi le score maximum à atteindre
		int num_gagnant;
		Random rand = new Random(); //Déclaration d'un objet de type random servant à placer les nombres aléatoirement dans le tableau
		
		//FIN DE LA DECLARATION DES VARIABLES GLOBALES
		
		
		//DEBUT DU CONSTRUCTEUR
		
		public Projet2048 ()
			{
				this.GenererGrille();
			}
		
		//FIN DU CONSTRUCTEUR
		
		
		//DEBUT DE LA METHODE GenererGrille()
		
		public void GenererGrille ()
			{
				for (int a=0; a<2; a++) //Cette boucle va nous permettre de générer 2 entiers
					{
						int min=0;
						int max=3;
						int min2 = 2;
						int max2 = 4;
						nb1 = rand.nextInt(max - min + 1) + min; //Cette instruction nous permettra de placer les valeurs aléatoirement dans la grille
						nb2 = rand.nextInt(max - min + 1) + min; //IDEM
						int nombreAleatoire = rand.nextInt(max2 - min2 + 1) + min2; //La valeur qui sera placée aléatoirement
						if (nombreAleatoire == 3) //On ne souhaite que la valeur 2 ou 4, si cette dernière est différente, on va la modifier
							{
								min2 = 0;
								max2 = 0;
								int nombreAleatoire2 = rand.nextInt(max2 - min2 + 1) + min2; //On génère un nombre entre 0 et 1 afin de savoir si l'on va additionner ou soustraire 1 à la variable nombreAleatoire
								if (nombreAleatoire2 == 1)
									{
										nombreAleatoire = nombreAleatoire + nombreAleatoire2; //nombreAleatoire vaudra 4
										grille[nb1][nb2] = nombreAleatoire; //On place la valeur
									}
								else
									{
										nombreAleatoire = nombreAleatoire - 1; //nombreAleatoire vaudra 2
										grille[nb1][nb2] = nombreAleatoire;
									}
							}
						grille[nb1][nb2] = nombreAleatoire;
					}
			}
		
		//FIN DE LA METHODE GenererGrille()
		
		
		//DEBUT DE LA METHODE defaite()
		
		public int defaite ()
			{
				int estVide = 0;
				for (nb1=0;nb1<=3;nb1++)
					{
						for (nb2=0;nb2<=3;nb2++) //On analyse l'ensemble de la grille pour déterminer si toutes les cases sont remplies
							{
								if (grille[nb1][nb2] == 0)
									{
										estVide = estVide + 1;
									}
							}
					}
				if (estVide == 0) //Si toutes les cases sont remplies, autrement dit si estVide est faux
					{
					
						//TRAITEMENT PREMIERE COLONNE
						if (grille[0][0] != grille[1][0] && grille[0][0] != grille[0][1]) //On vérifie que l'on ne peut pas additionner un élément avec ses éléments environnants
							{
								defaite = defaite + 1;
							}
						if (grille[1][0] != grille[2][0] && grille[1][0] != grille[1][1] && grille[1][0] != grille[0][0])
							{
								defaite = defaite + 1;
							}
						if (grille[2][0] != grille[3][0] && grille[2][0] != grille[2][1] && grille[2][0] != grille[1][0])
							{
								defaite = defaite + 1;
							}
						if (grille[3][0] != grille[2][0] && grille[3][0] != grille[3][1])
							{
								defaite = defaite + 1;
							}
						//FIN TRAITEMENT PREMIERE COLONNE
						
						//TRAITEMENT DEUXIEME COLONNE
						if (grille[0][1] != grille[0][0] && grille[0][1] != grille[1][1] && grille[0][1] != grille[0][2])
							{
								defaite = defaite + 1;
							}
						if (grille[1][1] != grille[0][1] && grille[1][1] != grille[2][1] && grille[1][1] != grille[1][0] && grille[1][1] != grille[1][2])
							{
								defaite = defaite + 1;
							}
						if (grille[2][1] != grille[1][1] && grille[2][1] != grille[3][1] && grille[2][1] != grille[2][0] && grille[2][1] != grille[2][2])
							{
								defaite = defaite + 1;
							}
						if (grille[3][1] != grille[2][1] && grille[3][1] != grille[3][0] && grille[3][1] != grille[3][2])
							{
								defaite = defaite + 1;
							}
						//FIN TRAITEMENT DEUXIEME COLONNE
						
						//TRAITEMENT TROISIEME COLONNE
						if (grille[0][2] != grille[0][1] && grille[0][2] != grille[1][2] && grille[0][2] != grille[0][3])
							{
								defaite = defaite + 1;
							}
						if (grille[1][2] != grille[0][2] && grille[1][2] != grille[2][2] && grille[1][2] != grille[1][1] && grille[1][2] != grille[1][3])
							{
								defaite = defaite + 1;
							}
						if (grille[2][2] != grille[1][2] && grille[2][2] != grille[3][2] && grille[2][2] != grille[2][1] && grille[2][2] != grille[2][3])
							{
								defaite = defaite + 1;
							}
						if (grille[3][2] != grille[2][2] && grille[3][2] != grille[3][1] && grille[3][2] != grille[3][3])
							{
								defaite = defaite + 1;
							}
						//FIN TRAITEMENT TROISIEME COLONNE
						
						//TRAITEMENT QUATRIEME COLONNE
						if (grille[0][3] != grille[0][2] && grille[0][3] != grille[1][3])
							{
								defaite = defaite + 1;
							}
						if (grille[1][3] != grille[1][2] && grille[1][3] != grille[0][3] && grille[1][3] != grille[2][3])
							{
								defaite = defaite + 1;
							}
						if (grille[2][3] != grille[1][3] && grille[2][3] != grille[2][2] && grille[2][3] != grille[3][3])
							{
								defaite = defaite + 1;
							}
						if (grille[3][3] != grille[3][2] && grille[3][3] != grille[2][3])
							{
								defaite = defaite + 1;
							}
						//FIN TRAITEMENT QUATRIEME COLONNE
					}
				return defaite;
			}
		
		//FIN DE LA METHODE defaite()
		
		
		//DEBUT DE LA METHODE victoire()
		
		public int victoire (int num_gagnant2)
			{
				boucle_1: for (nb1=0;nb1<=3;nb1++)
					{
						for (nb2=0;nb2<=3;nb2++)
							{
								if (grille[nb1][nb2] == num_gagnant2 )
									{
										victoire = 1;
										break boucle_1;
									}
								else
									{
										victoire = 0;
									}
							}
					}
				return victoire;
			}
		
		//FIN DE LA METHODE victoire()
		
		
		//DEBUT DE LA METHODE choixVictoire()
		
		public int choixVictoire()
			{
				System.out.println("Choisissez quel sera le score gagnant (le nombre doit être une puissance de 2 !)");
				System.out.println("Exemple : 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096 etc.");
				int booleen = 0;
				int tab_verif [] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
				while (booleen != 1)
					{
						System.out.println("Veuillez saisir un nombre valide");
						num_gagnant = saisie.nextInt();
						int i = 0;
						while (booleen != 1 && i <= 19)
							{
								if (Math.log(num_gagnant) / Math.log(2) != tab_verif[i]) //Cette formule nous permet de vérifier que le nombre saisie est une puissance de 2.
									{ 													//Si le résultant est un entier, alors le nombre est une puissance de 2. Sinon, il ne l'est pas.
										booleen = 0;
									}
								else
									{
										booleen = 1;
									}
								i = i+1;
							}
					}
				return num_gagnant;
			}
		
		//FIN DE LA METHODE choixVictoire()
		
		
		//DEBUT DE LA METHODE NombreAleatoire ()
		
		public int[] NombreAleatoire () //Méthode nous permettant de générer un nombre aléatoire après un déplacement réussit
			{
				int min2 = 2;
				int max2 = 4;
				int min=0;
				int max=3;
				nb1 = rand.nextInt(max - min + 1) + min;
				nb2 = rand.nextInt(max - min + 1) + min;
				int tab[] = {0,0,0};
				int nombreAleatoire = rand.nextInt(max2 - min2 + 1) + min2;
				if (nombreAleatoire == 3)
					{
						
						min2 = 0;
						max2 = 0;
						int nombreAleatoire2 = rand.nextInt(max2 - min2 + 1) + min2;
						if (nombreAleatoire2 == 1)
							{
								nombreAleatoire = nombreAleatoire + nombreAleatoire2;
								tab[0] = nombreAleatoire;
							}
						else
							{
								nombreAleatoire = nombreAleatoire - 1;
								tab[0] = nombreAleatoire;
							}
					}
				tab[0] = nombreAleatoire;
				tab[1] = nb1;
				tab[2] = nb2;
				return tab; //On retourne un tableau contenant 3 choses : le nombre généré ainsi que les 2 indices
			}
		
		//FIN DE LA METHODE NombreAleatoire()
		
		
		//DEBUT DE LA METHODE deplacement()
		
		public void deplacement ()
			{
				char direction;
				int succes_deplacement;
				System.out.println("Z pour monter, D pour la droite, S pour descendre, Q pour la gauche");
				while (victoire != 1 || defaite != 16)
					{
						defaite = 0;
						direction = saisie.next().charAt(0);
						switch (direction)
							{
								case 'z' :	System.out.println("Déplacement vers le haut");
									succes_deplacement = 0;
									for (nb2=0;nb2<=3;nb2++) //On se déplace ligne par ligne en fonction d'une colonne
										{
											for (nb1=3;nb1>0;nb1--)
												{
													switch (nb1) //suivant la ligne
														{
															case 3 :	if (grille[nb1][nb2] != 0)
																			{
																				if (grille[nb1-1][nb2] == 0)
																					{
																						grille[nb1-1][nb2] = grille[nb1][nb2];
																						grille[nb1][nb2] = 0;
																						succes_deplacement = 1;
																					}
																				else if (grille[nb1-1][nb2] == grille[nb1][nb2])
																					{
																						grille[nb1-1][nb2] = grille[nb1-1][nb2] + grille[nb1][nb2];
																						grille[nb1][nb2] = 0;
																						succes_deplacement = 1;
																						score = score + grille[nb1-1][nb2];
																					}
																			}
															break;
															
															case 2 :	if (grille[nb1][nb2] != 0)
																			{
																				if (grille[nb1-1][nb2] == grille[nb1][nb2])
																					{
																						grille[nb1-1][nb2] = grille[nb1-1][nb2] + grille[nb1][nb2];
																						score = score + grille[nb1-1][nb2];
																						if (grille[nb1+1][nb2] != 0)
																							{
																								grille[nb1][nb2] = grille[nb1+1][nb2];
																								grille[nb1+1][nb2] = 0;
																							}
																						else
																							{
																								grille[nb1][nb2] = 0;
																							}
																						succes_deplacement = 1;
																					}
																				else if (grille[nb1-1][nb2] == 0)
																					{
																						grille[nb1-1][nb2] = grille[nb1][nb2];
																						grille[nb1][nb2] = 0;
																						if (grille[nb1+1][nb2] != 0)
																							{
																								grille[nb1][nb2] = grille[nb1+1][nb2];
																								grille[nb1+1][nb2] = 0;
																							}
																						else
																							{
																								grille[nb1][nb2] = 0;
																							}
																						succes_deplacement = 1;
																					}
																			}
															break;
															
															case 1 :	if (grille[nb1][nb2] != 0)
																			{
																				if (grille[nb1-1][nb2] == grille[nb1][nb2])
																					{
																						grille[nb1-1][nb2] = grille[nb1-1][nb2] + grille[nb1][nb2];
																						score = score + grille[nb1-1][nb2];
																						if (grille[nb1+1][nb2] != 0)
																							{
																								grille[nb1][nb2] = grille[nb1+1][nb2];
																								grille[nb1+1][nb2] = 0;
																							}
																						else
																							{
																								grille[nb1][nb2] = 0;
																							}
																						if (grille[nb1+2][nb2] != 0)
																							{
																								grille[nb1+1][nb2] = grille[nb1+2][nb2];
																								grille[nb1+2][nb2] = 0;
																							}
																						succes_deplacement = 1;
																					}
																				else if (grille[nb1-1][nb2] == 0)
																					{
																						grille[nb1-1][nb2] = grille[nb1][nb2];
																						grille[nb1][nb2] = 0;
																						if (grille[nb1+1][nb2] != 0)
																							{
																								grille[nb1][nb2] = grille[nb1+1][nb2];
																								grille[nb1+1][nb2] = 0;
																							}
																						else
																							{
																								grille[nb1][nb2] = 0;
																							}
																						if (grille[nb1+2][nb2] != 0)
																							{
																								grille[nb1+1][nb2] = grille[nb1+2][nb2];
																								grille[nb1+2][nb2] = 0;
																							}
																						succes_deplacement = 1;
																					}
																			}
															break;
														}
												}
										}
									if (succes_deplacement == 1)
										{
											int tab[] = NombreAleatoire();
											nb1 = tab[1];
											nb2 = tab[2];
											while (grille[nb1][nb2] != 0)
												{
													tab = NombreAleatoire();
												}
											grille[nb1][nb2] = tab[0];
										}
									Affiche();
								break;
									
								case 'd' :	System.out.println("Déplacement vers la droite");
									succes_deplacement = 0;
									for (nb1=0;nb1<=3;nb1++) //On se déplace colonne par colonne en fonction de la ligne, de gauche à droite
										{
											for (nb2=0;nb2<3;nb2++)
												{
													switch (nb2)
														{
															case 0 :	if (grille[nb1][nb2] != 0)
																			{
																				if (grille[nb1][nb2+1] == 0)
																					{
																						grille[nb1][nb2+1] = grille[nb1][nb2];
																						grille[nb1][nb2] = 0;
																						succes_deplacement = 1;
																					}
																				else if (grille[nb1][nb2+1] == grille[nb1][nb2])
																					{
																						grille[nb1][nb2+1] = grille[nb1][nb2+1] + grille[nb1][nb2];
																						grille[nb1][nb2] = 0;
																						succes_deplacement = 1;
																						score = score + grille[nb1][nb2+1];
																					}
																			}
															break;
															
															case 1 :	if (grille[nb1][nb2] != 0)
																			{
																				if (grille[nb1][nb2+1] == grille[nb1][nb2])
																					{
																						grille[nb1][nb2+1] = grille[nb1][nb2+1] + grille[nb1][nb2];
																						score = score + grille[nb1][nb2+1];
																						if (grille[nb1][nb2-1] != 0)
																							{
																								grille[nb1][nb2] = grille[nb1][nb2-1];
																								grille[nb1][nb2-1] = 0;
																							}
																						else
																							{
																								grille[nb1][nb2] = 0;
																							}
																						succes_deplacement = 1;
																					}
																				else if (grille[nb1][nb2+1] == 0)
																					{
																						grille[nb1][nb2+1] = grille[nb1][nb2];
																						grille[nb1][nb2] = 0;
																						if (grille[nb1][nb2-1] != 0)
																							{
																								grille[nb1][nb2] = grille[nb1][nb2-1];
																								grille[nb1][nb2-1] = 0;
																							}
																						else
																							{
																								grille[nb1][nb2] = 0;
																							}
																						succes_deplacement = 1;
																					}
																			}
															break;
															
															case 2 :	if (grille[nb1][nb2] != 0)
																			{
																				if (grille[nb1][nb2+1] == grille[nb1][nb2])
																					{
																						grille[nb1][nb2+1] = grille[nb1][nb2+1] + grille[nb1][nb2];
																						score = score + grille[nb1][nb2+1];
																						if (grille[nb1][nb2-1] != 0)
																							{
																								grille[nb1][nb2] = grille[nb1][nb2-1];
																								grille[nb1][nb2-1] = 0;
																							}
																						else
																							{
																								grille[nb1][nb2] = 0;
																							}
																						if (grille[nb1][nb2-2] != 0)
																							{
																								grille[nb1][nb2-1] = grille[nb1][nb2-2];
																								grille[nb1][nb2-2] = 0;
																							}
																						succes_deplacement = 1;
																					}
																				else if (grille[nb1][nb2+1] == 0)
																					{
																						grille[nb1][nb2+1] = grille[nb1][nb2];
																						grille[nb1][nb2] = 0;
																						if (grille[nb1][nb2-1] != 0)
																							{
																								grille[nb1][nb2] = grille[nb1][nb2-1];
																								grille[nb1][nb2-1] = 0;
																							}
																						else
																							{
																								grille[nb1][nb2] = 0;
																							}
																						if (grille[nb1][nb2-2] != 0)
																							{
																								grille[nb1][nb2-1] = grille[nb1][nb2-2];
																								grille[nb1][nb2-2] = 0;
																							}
																						succes_deplacement = 1;
																					}
																			}
															break;
														}
												}
										}
									if (succes_deplacement == 1)
										{
											int tab[] = NombreAleatoire();
											nb1 = tab[1];
											nb2 = tab[2];
											while (grille[nb1][nb2] != 0)
												{
													tab = NombreAleatoire();
												}
											grille[nb1][nb2] = tab[0];
										}
									Affiche();
								break;
								
								case 's' :	System.out.println("Déplacement vers le bas"); //On se déplace ligne par ligne en fonction de la colonne, de bas en haut
									succes_deplacement = 0;
									for (nb2=0;nb2<=3;nb2++)
										{
											for (nb1=0;nb1<3;nb1++)
												{
													switch (nb1)
														{
															case 0 :	if (grille[nb1][nb2] != 0)
																			{
																				if (grille[nb1+1][nb2] == 0)
																					{
																						grille[nb1+1][nb2] = grille[nb1][nb2];
																						grille[nb1][nb2] = 0;
																						succes_deplacement = 1;
																					}
																				else if (grille[nb1+1][nb2] == grille[nb1][nb2])
																					{
																						grille[nb1+1][nb2] = grille[nb1+1][nb2] + grille[nb1][nb2];
																						grille[nb1][nb2] = 0;
																						succes_deplacement = 1;
																						score = score + grille[nb1+1][nb2];
																					}
																			}
															break;
															
															case 1 :	if (grille[nb1][nb2] != 0)
																			{
																				if (grille[nb1+1][nb2] == grille[nb1][nb2])
																					{
																						grille[nb1+1][nb2] = grille[nb1+1][nb2] + grille[nb1][nb2];
																						score = score + grille[nb1+1][nb2];
																						if (grille[nb1-1][nb2] != 0)
																							{
																								grille[nb1][nb2] = grille[nb1-1][nb2];
																								grille[nb1-1][nb2] = 0;
																							}
																						else
																							{
																								grille[nb1][nb2] = 0;
																							}
																						succes_deplacement = 1;
																					}
																				else if (grille[nb1+1][nb2] == 0)
																					{
																						grille[nb1+1][nb2] = grille[nb1][nb2];
																						grille[nb1][nb2] = 0;
																						if (grille[nb1-1][nb2] != 0)
																							{
																								grille[nb1][nb2] = grille[nb1-1][nb2];
																								grille[nb1-1][nb2] = 0;
																							}
																						else
																							{
																								grille[nb1][nb2] = 0;
																							}
																						succes_deplacement = 1;
																					}
																			}
															break;
															
															case 2 :	if (grille[nb1][nb2] != 0)
																			{
																				if (grille[nb1+1][nb2] == grille[nb1][nb2])
																					{
																						grille[nb1+1][nb2] = grille[nb1+1][nb2] + grille[nb1][nb2];
																						score = score + grille[nb1+1][nb2];
																						if (grille[nb1-1][nb2] != 0)
																							{
																								grille[nb1][nb2] = grille[nb1-1][nb2];
																								grille[nb1-1][nb2] = 0;
																							}
																						else
																							{
																								grille[nb1][nb2] = 0;
																							}
																						if (grille[nb1-2][nb2] != 0)
																							{
																								grille[nb1-1][nb2] = grille[nb1-2][nb2];
																								grille[nb1-2][nb2] = 0;
																							}
																						succes_deplacement = 1;
																					}
																				else if (grille[nb1+1][nb2] == 0)
																					{
																						grille[nb1+1][nb2] = grille[nb1][nb2];
																						grille[nb1][nb2] = 0;
																						if (grille[nb1-1][nb2] != 0)
																							{
																								grille[nb1][nb2] = grille[nb1-1][nb2];
																								grille[nb1-1][nb2] = 0;
																							}
																						else
																							{
																								grille[nb1][nb2] = 0;
																							}
																						if (grille[nb1-2][nb2] != 0)
																							{
																								grille[nb1-1][nb2] = grille[nb1-2][nb2];
																								grille[nb1-2][nb2] = 0;
																							}
																						succes_deplacement = 1;
																					}
																			}
															break;
														}
												}
										}
									if (succes_deplacement == 1)
										{
											int tab[] = NombreAleatoire();
											nb1 = tab[1];
											nb2 = tab[2];
											while (grille[nb1][nb2] != 0)
												{
													tab = NombreAleatoire();
												}
											grille[nb1][nb2] = tab[0];
										}
									Affiche();
								break;
								
								case 'q' :	System.out.println("Déplacement vers la gauche"); //On se déplace de colonne en colonne en fonction de la ligne, de droite à gauche
									succes_deplacement = 0;
									for (nb1=0;nb1<=3;nb1++)
										{
											for (nb2=3;nb2>0;nb2--)
												{
													switch (nb2)
														{
															case 3 :	if (grille[nb1][nb2] != 0)
																			{
																				if (grille[nb1][nb2-1] == 0)
																					{
																						grille[nb1][nb2-1] = grille[nb1][nb2];
																						grille[nb1][nb2] = 0;
																						succes_deplacement = 1;
																					}
																				else if (grille[nb1][nb2-1] == grille[nb1][nb2])
																					{
																						grille[nb1][nb2-1] = grille[nb1][nb2-1] + grille[nb1][nb2];
																						score = score + grille[nb1][nb2-1];
																						grille[nb1][nb2] = 0;
																						succes_deplacement = 1;
																					}
																			}
															break;
															
															case 2 :	if (grille[nb1][nb2] != 0)
																			{
																				if (grille[nb1][nb2-1] == grille[nb1][nb2])
																					{
																						grille[nb1][nb2-1] = grille[nb1][nb2-1] + grille[nb1][nb2];
																						score = score + grille[nb1][nb2-1];
																						if (grille[nb1][nb2+1] != 0)
																							{
																								grille[nb1][nb2] = grille[nb1][nb2+1];
																								grille[nb1][nb2+1] = 0;
																							}
																						else
																							{
																								grille[nb1][nb2] = 0;
																							}
																						succes_deplacement = 1;
																					}
																				else if (grille[nb1][nb2-1] == 0)
																					{
																						grille[nb1][nb2-1] = grille[nb1][nb2];
																						grille[nb1][nb2] = 0;
																						if (grille[nb1][nb2+1] != 0)
																							{
																								grille[nb1][nb2] = grille[nb1][nb2+1];
																								grille[nb1][nb2+1] = 0;
																							}
																						else
																							{
																								grille[nb1][nb2] = 0;
																							}
																						succes_deplacement = 1;
																					}
																			}
															break;
															
															case 1 :	if (grille[nb1][nb2] != 0)
																			{
																				if (grille[nb1][nb2-1] == grille[nb1][nb2])
																					{
																						grille[nb1][nb2-1] = grille[nb1][nb2-1] + grille[nb1][nb2];
																						score = score + grille[nb1][nb2-1];
																						if (grille[nb1][nb2+1] != 0)
																							{
																								grille[nb1][nb2] = grille[nb1][nb2+1];
																								grille[nb1][nb2+1] = 0;
																							}
																						else
																							{
																								grille[nb1][nb2] = 0;
																							}
																						if (grille[nb1][nb2+2] != 0)
																							{
																								grille[nb1][nb2+1] = grille[nb1][nb2+2];
																								grille[nb1][nb2+2] = 0;
																							}
																						succes_deplacement = 1;
																					}
																				else if (grille[nb1][nb2-1] == 0)
																					{
																						grille[nb1][nb2-1] = grille[nb1][nb2];
																						grille[nb1][nb2] = 0;
																						if (grille[nb1][nb2+1] != 0)
																							{
																								grille[nb1][nb2] = grille[nb1][nb2+1];
																								grille[nb1][nb2+1] = 0;
																							}
																						else
																							{
																								grille[nb1][nb2] = 0;
																							}
																						if (grille[nb1][nb2+2] != 0)
																							{
																								grille[nb1][nb2+1] = grille[nb1][nb2+2];
																								grille[nb1][nb2+2] = 0;
																							}
																						succes_deplacement = 1;
																					}
																			}
															break;
														}
												}
										}
									if (succes_deplacement == 1)
										{
											int tab[] = NombreAleatoire();
											nb1 = tab[1];
											nb2 = tab[2];
											while (grille[nb1][nb2] != 0)
												{
													tab = NombreAleatoire();
												}
											grille[nb1][nb2] = tab[0];
										}
									Affiche();
								break;
								
							}
						if (defaite() == 16)
							{
								System.out.println("Vous avez perdu");
								System.out.println("Score: " +score);
								System.exit(0);
							}
						if (victoire(num_gagnant) == 1)
							{
								System.out.println("Vous avez gagné !");
								System.out.println("Score: " +score);
								System.exit(0);
							}
					}
			}
		
		//FIN DE LA METHODE deplacement()
		
		
		//DEBUT DE LA METHODE Affiche()
		
		public void Affiche () //Sert à afficher la grille
			{
				for (int i=0;i<4;i++)
					{
						for (int j=0;j<4;j++)
							{
								
								System.out.print("|_____"+grille[i][j]+"_____|");
								
							}
						System.out.println();
					}
			}
		
		//FIN DE LA METHODE Affiche()
		
	
		//DEBUT DU MAIN
		
		public static void main(String[] args) 
			{
				Projet2048 jeu = new Projet2048();
				jeu.choixVictoire();
				jeu.Affiche();
				jeu.deplacement();
			}
		
		//FIN DU MAIN
	}
