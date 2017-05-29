public 	class MaCu{
		int A[][]=new int[3][3] ;int B[][]=new int [3][3] ;int C[][]=new int[3][3] ;
		int D[][]=new int[3][3] ;int E[][]=new int [3][3] ;int F[][]=new int[3][3];
		int fa_nu;
		int ow_nu;
		public MaCu(int a1,int a2,int a3,int a4,int a5,int a6,int a7,int a8,int a9,
		int b1,int b2,int b3,int b4,int b5,int b6,int b7,int b8,int b9,
		int c1,int c2,int c3,int c4,int c5,int c6,int c7,int c8,int c9,
		int d1,int d2,int d3,int d4,int d5,int d6,int d7,int d8,int d9,
		int e1,int e2,int e3,int e4,int e5,int e6,int e7,int e8,int e9,
		int f1,int f2,int f3,int f4,int f5,int f6,int f7,int f8,int f9,int ownu,int fanu){
		A[0][0]=a1;A[0][1]=a2;A[0][2]=a3;A[1][0]=a4;A[1][1]=a5;A[1][2]=a6;A[2][0]=a7;A[2][1]=a8;A[2][2]=a9;
		B[0][0]=b1;B[0][1]=b2;B[0][2]=b3;B[1][0]=b4;B[1][1]=b5;B[1][2]=b6;B[2][0]=b7;B[2][1]=b8;B[2][2]=b9;
		C[0][0]=c1;C[0][1]=c2;C[0][2]=c3;C[1][0]=c4;C[1][1]=c5;C[1][2]=c6;C[2][0]=c7;C[2][1]=c8;C[2][2]=c9;
		D[0][0]=d1;D[0][1]=d2;D[0][2]=d3;D[1][0]=d4;D[1][1]=d5;D[1][2]=d6;D[2][0]=d7;D[2][1]=d8;D[2][2]=d9;
		E[0][0]=e1;E[0][1]=e2;E[0][2]=e3;E[1][0]=e4;E[1][1]=e5;E[1][2]=e6;E[2][0]=e7;E[2][1]=e8;E[2][2]=e9;
		F[0][0]=f1;F[0][1]=f2;F[0][2]=f3;F[1][0]=f4;F[1][1]=f5;F[1][2]=f6;F[2][0]=f7;F[2][1]=f8;F[2][2]=f9;
		ow_nu=ownu;
		fa_nu=fanu;
		}
		/*public MaCu(int a[3][3],int b[3][3],int c[3][3],int d[3][3],int e[3][3],int f[3][3]){
			super(a[0][0],a[0][1],a[0][2],a[1][0],a[1][1],a[1][2],a[2][0],a[2][1],a[2][2],
		b[0][0],b[0][1],b[0][2],b[1][0],b[1][1],b[1][2],b[2][0],b[2][1],b[2][2],
		c[0][0],c[0][1],c[0][2],c[1][0],c[1][1],c[1][2],c[2][0],c[2][1],c[2][2],
		d[0][0],d[0][1],d[0][2],d[1][0],d[1][1],d[1][2],d[2][0],d[2][1],d[2][2],
		e[0][0],e[0][1],e[0][2],e[1][0],e[1][1],e[1][2],e[2][0],e[2][1],e[2][2],
		f[0][0],f[0][1],f[0][2],f[1][0],f[1][1],f[1][2],f[2][0],f[2][1],f[2][2])
		}*/
		/*public MaCu(int a[9],int b[9],int c[9],int d[9],int e[9],int f[9]){
			super(a[0],a[1],a[2],a[3],a[4],a[5],a[6],a[7],a[8],
				b[0],b[1],b[2],b[3],b[4],b[5],b[6],b[7],b[8],
				c[0],[1],c[2],c[3],c[4],c[5],c[6],c[7],c[8],
				d[0],d[1],d[2],d[3],d[4],d[5],d[6],d[7],d[8],
				e[0],e[1],e[2],e[3],e[4],e[5],e[6],e[7],e[8],
				f[0],f[1],f[2],f[3],f[4],f[5],f[6],f[7],f[8],
		}*/
		public MaCu(){}
		public MaCu(MaCu a,int ownu,int fanu){
			for(int i=0;i<3;i++)
				for(int j=0;j<3;j++){
					this.A[i][j]=a.A[i][j];
					this.B[i][j]=a.B[i][j];
					this.C[i][j]=a.C[i][j];
					this.D[i][j]=a.D[i][j];
					this.E[i][j]=a.E[i][j];
					this.F[i][j]=a.F[i][j];
					ow_nu=ownu;
					fa_nu=fanu;
				}
		}
		public void  rightroll(char b){
			int temp [][]={{0,0,0},{0,0,0},{0,0,0}};
			switch (b){
				case 'A':
				for(int i=0;i<3;i++)
					for(int j=0;j<3;j++){
						temp[i][j]=this.A[2-j][i];
					}
				for(int i=0;i<3;i++)
					for(int j=0;j<3;j++){
						this.A[i][j]=temp[i][j];
					}	
				break;
				case 'B':
				for(int i=0;i<3;i++)
					for(int j=0;j<3;j++){
						temp[i][j]=this.B[2-j][i];
					}
				for(int i=0;i<3;i++)
					for(int j=0;j<3;j++){
						this.B[i][j]=temp[i][j];
				}break;
				case 'C':
				for(int i=0;i<3;i++)
					for(int j=0;j<3;j++){
						temp[i][j]=this.C[2-j][i];
					}
				for(int i=0;i<3;i++)
					for(int j=0;j<3;j++){
						this.C[i][j]=temp[i][j];
				}	
				break;
				case 'D':
				for(int i=0;i<3;i++)
					for(int j=0;j<3;j++){
						temp[i][j]=this.D[2-j][i];
					}
				for(int i=0;i<3;i++)
					for(int j=0;j<3;j++){
						this.D[i][j]=temp[i][j];
				}	
				break;
				case 'E':
				for(int i=0;i<3;i++)
					for(int j=0;j<3;j++){
						temp[i][j]=this.E[2-j][i];
					}
				for(int i=0;i<3;i++)
					for(int j=0;j<3;j++){
						this.E[i][j]=temp[i][j];
				}break;
				case 'F':
				for(int i=0;i<3;i++)
					for(int j=0;j<3;j++){
						temp[i][j]=this.F[2-j][i];
					}
				for(int i=0;i<3;i++)
					for(int j=0;j<3;j++){
						this.F[i][j]=temp[i][j];
				}break;
				default:System.out.println("you get the wrong number");
			}
		}	
		public void  leftroll(char b){
			int temp [][]={{0,0,0},{0,0,0},{0,0,0}};
			switch (b){
				case 'A':
				for(int i=0;i<3;i++)
					for(int j=0;j<3;j++){
						temp[i][j]=this.A[j][i];
					}
				for(int i=0;i<3;i++)
					for(int j=0;j<3;j++){
						this.A[i][j]=temp[i][j];
					}	
				break;
				case 'B':
				for(int i=0;i<3;i++)
					for(int j=0;j<3;j++){
						temp[i][j]=this.B[j][i];
					}
				for(int i=0;i<3;i++)
					for(int j=0;j<3;j++){
						this.B[i][j]=temp[i][j];
				}break;
				case 'C':
				for(int i=0;i<3;i++)
					for(int j=0;j<3;j++){
						temp[i][j]=this.C[j][i];
					}
				for(int i=0;i<3;i++)
					for(int j=0;j<3;j++){
						this.C[i][j]=temp[i][j];
				}	
				break;
				case 'D':
				for(int i=0;i<3;i++)
					for(int j=0;j<3;j++){
						temp[i][j]=this.D[j][i];
					}
				for(int i=0;i<3;i++)
					for(int j=0;j<3;j++){
						this.D[i][j]=temp[i][j];
				}	
				break;
				case 'E':
				for(int i=0;i<3;i++)
					for(int j=0;j<3;j++){
						temp[i][j]=this.E[j][i];
					}
				for(int i=0;i<3;i++)
					for(int j=0;j<3;j++){
						this.E[i][j]=temp[i][j];
				}break;
				case 'F':
				for(int i=0;i<3;i++)
					for(int j=0;j<3;j++){
						temp[i][j]=this.F[j][i];
					}
				for(int i=0;i<3;i++)
					for(int j=0;j<3;j++){
						this.F[i][j]=temp[i][j];
				}break;
				default:System.out.println("you get the wrong number");
			}	
		}
	public void display(){
		System.out.println("A		B		C		D		E		F		");
		for(int i=0;i<3;i++){
				System.out.print(this.A[i][0]+" "+this.A[i][1]+" "+this.A[i][2]+"		");
				System.out.print(this.B[i][0]+" "+this.B[i][1]+" "+this.B[i][2]+"		");
				System.out.print(this.C[i][0]+" "+this.C[i][1]+" "+this.C[i][2]+"		");
				System.out.print(this.D[i][0]+" "+this.D[i][1]+" "+this.D[i][2]+"		");
				System.out.print(this.E[i][0]+" "+this.E[i][1]+" "+this.E[i][2]+"		");
				System.out.print(this.F[i][0]+" "+this.F[i][1]+" "+this.F[i][2]+"		\n");
				
		}
	}
	public int equal(MaCu t){
		int noequal=0 ;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(this.A[i][j]!=t.A[i][j]) {noequal=1;break;}
			}		
		}if(noequal==0)System.out.println("equal");
		return noequal;
	}
	public void is(MaCu t,int fanu,int ownu){
		for(int i=0;i<3;i++){
				for(int j=0;j<3;j++){
					this.A[i][j]=t.A[i][j];
					this.B[i][j]=t.B[i][j];
					this.C[i][j]=t.C[i][j];
					this.D[i][j]=t.D[i][j];
					this.E[i][j]=t.E[i][j];
					this.F[i][j]=t.F[i][j];
					ow_nu=ownu;
					fa_nu=fanu;
				}
		}
	}
	public void oprate(char a,char b){
		int t[]=new int[3];
		switch(b){
			case '1':switch(a){
				 	case 'L':this.leftroll('D');
						for(int i=0;i<3;i++){
							t[i]=this.E[i][0];	
						}
						for(int i=0;i<3;i++){
							this.E[i][0]=this.A[i][0];	
						}
						for(int i=0;i<3;i++){
							this.A[i][0]=this.F[i][0];	
						}
						for(int i=0;i<3;i++){
							this.F[i][0]=this.C[2-i][2];	
						}
						for(int i=0;i<3;i++){
							this.C[2-i][2]=t[i];	
						}break;
					case'R':this.rightroll('B');
						for(int i=0;i<3;i++){
							t[i]=this.E[i][2];	
						}
						for(int i=0;i<3;i++){
							this.E[i][2]=this.A[i][2];	
						}
						for(int i=0;i<3;i++){
							this.A[i][2]=this.F[i][2];	
						}
						for(int i=0;i<3;i++){
							this.F[i][2]=this.C[2-i][0];	
						}
						for(int i=0;i<3;i++){
							this.C[2-i][0]=t[i];	
						}break;
					case'U':this.rightroll('E');
						for(int i=0;i<3;i++){
							t[i]=this.A[0][i];	
						}
						for(int i=0;i<3;i++){
							this.A[0][i]=this.B[0][i];	
						}
						for(int i=0;i<3;i++){
							this.B[0][i]=this.C[0][i];	
						}
						for(int i=0;i<3;i++){
							this.C[0][i]=this.D[0][i];	
						}
						for(int i=0;i<3;i++){
							this.D[0][i]=t[i];	
						}break;
					case'D':this.leftroll('F');
						for(int i=0;i<3;i++){
							t[i]=this.A[2][i];	
						}
						for(int i=0;i<3;i++){
							this.A[2][i]=this.B[2][i];	
						}
						for(int i=0;i<3;i++){
							this.B[2][i]=this.C[2][i];	
						}
						for(int i=0;i<3;i++){
							this.C[2][i]=this.D[2][i];	
						}
						for(int i=0;i<3;i++){
							this.D[2][i]=t[i];	
						}break;
					case'F':this.rightroll('A');
						for(int i=0;i<3;i++){
							t[i]=this.E[2][i];	
						}
						for(int i=0;i<3;i++){
							this.E[2][i]=this.D[i][2];	
						}
						for(int i=0;i<3;i++){
							this.D[i][2]=this.F[0][i];	
						}
						for(int i=0;i<3;i++){
							this.F[0][i]=this.B[i][0];	
						}
						for(int i=0;i<3;i++){
							this.B[i][0]=t[i];	
						}
						break;
					case'B':this.leftroll('C');
						for(int i=0;i<3;i++){
							t[i]=this.E[0][i];
						}
						for(int i=0;i<3;i++){
							this.E[0][i]=this.D[2-i][0];
						}
						for(int i=0;i<3;i++){
							this.D[i][0]=this.F[2][i];
						}
						for(int i=0;i<3;i++){
							this.F[2][i]=this.B[2-i][2];
						}
						for(int i=0;i<3;i++){
							this.B[i][2]=t[i];
						}
						break;	
				}break;
			case '0':switch(a){
				 	case 'L':this.rightroll('D');
						for(int i=0;i<3;i++){
							t[i]=this.E[i][0];	
						}
						for(int i=0;i<3;i++){
							this.E[i][0]=this.C[2-i][2];	
						}
						for(int i=0;i<3;i++){
							 this.C[2-i][2]=this.F[i][0];	
						}
						for(int i=0;i<3;i++){
							this.F[i][0]=this.A[i][0] ;	
						}
						for(int i=0;i<3;i++){
							this.A[i][0]=t[i];	
						}break;
					case 'R':this.leftroll('B');
						for(int i=0;i<3;i++){
							t[i]=this.E[i][2];	
						}
						for(int i=0;i<3;i++){
							this.E[i][2]=this.C[2-i][0];	
						}
						for(int i=0;i<3;i++){
							 this.C[2-i][0]=this.F[i][2];	
						}
						for(int i=0;i<3;i++){
							this.F[i][2]=this.A[i][2] ;	
						}
						for(int i=0;i<3;i++){
							this.A[i][2]=t[i];	
						}break;
					case 'U':this.leftroll('E');
						for(int i=0;i<3;i++){
							t[i]=this.A[0][i];	
						}
						for(int i=0;i<3;i++){
							this.A[0][i]=this.D[0][i];	
						}
						for(int i=0;i<3;i++){
							this.D[0][i]=this.C[0][i];	
						}
						for(int i=0;i<3;i++){
							this.C[0][i]=this.B[0][i];	
						}
						for(int i=0;i<3;i++){
							this.B[0][i]=t[i];	
						}break;
					case'D':this.rightroll('F');
						for(int i=0;i<3;i++){
							t[i]=this.A[2][i];	
						}
						for(int i=0;i<3;i++){
							this.A[2][i]=this.D[2][i];	
						}
						for(int i=0;i<3;i++){
							this.D[2][i]=this.C[2][i];	
						}
						for(int i=0;i<3;i++){
							this.C[2][i]=this.B[2][i];	
						}
						for(int i=0;i<3;i++){
							this.B[2][i]=t[i];	
						}break;
					case 'F':this.leftroll('A');
						for(int i=0;i<3;i++){
							t[i]=this.E[2][i];	
						}
						for(int i=0;i<3;i++){
							this.E[2][i]=this.B[i][0];    	
						}
						for(int i=0;i<3;i++){
							this.B[i][0]=this.F[0][i];	
						}
						for(int i=0;i<3;i++){
							this.F[0][i]=this.D[i][2];	
						}
						for(int i=0;i<3;i++){
							this.D[i][2]=t[i];	
						}break;
					case 'B':this.rightroll('C');
						for(int i=0;i<3;i++){
							t[i]=this.E[0][i];
						}
						for(int i=0;i<3;i++){
							this.E[0][i]=this.B[i][2];			
						}
						for(int i=0;i<3;i++){
							this.B[2-i][2]=this.F[2][i];
						}
						for(int i=0;i<3;i++){
							this.F[2][i]=this.D[i][0];
						}
						for(int i=0;i<3;i++){
							this.D[2-i][0]=t[i];
						}	
						break;	
				}break;
			default :System.out.println("here is error");
		}//return this;
	}
public static void main(String []args){	
	MaCu test1=new MaCu(1,1,1,1,1,1,1,1,1
		,2,2,2,2,2,2,2,2,2
		,3,3,3,3,3,3,3,3,3
		,4,4,4,4,4,4,4,4,4
		,5,5,5,5,5,5,5,5,5
		,6,6,6,6,6,6,6,6,6,0,0);
		MaCu des=new MaCu(1,1,1,1,1,1,1,1,1
		,2,2,2,2,2,2,2,2,2
		,3,3,3,3,3,3,3,3,3
		,4,4,4,4,4,4,4,4,4
		,5,5,5,5,5,5,5,5,5
		,6,6,6,6,6,6,6,6,6,0,0);
		//System.out.println(test1.equal(des));
			test1.display();
			//test1.leftroll('A');
			//test1.oprate('U','1');
			//test1.oprate('U','1');
			//test1.display();
			MaCu test[]=new MaCu[2000];
			test[0]=test1;
			test[0].display();
			MaCu temp=new MaCu();
			int father=0,point=1,end=0;
			do{	
				if(end==1){System.out.println("you are right!congratulations");break;}
				for(int t=1;t<13;t++)//U D L R F B
				{	System.out.println(father+"	"+t  );temp.is(test[father],0,0);temp.display();
					//if(test[point-1].equal(des)==0){end =1;
					//test[point-1].display();break;}
					switch(t){
					/*	case 1:temp.oprate('U','0');test[point].is(temp,father,point);break;
						case 2:test[point].is(temp.oprate('U','1'),father,point);break;
						case 3:test[point].is(temp.oprate('D','0'),father,point);break;
						case 4:test[point].is(temp.oprate('D','1'),father,point);break;
						case 5:test[point].is(temp.oprate('L','0'),father,point);break;
						case 6:test[point].is(temp.oprate('L','1'),father,point);break;
						case 7:test[point].is(temp.oprate('R','0'),father,point);break;
						case 8:test[point].is(temp.oprate('R','1'),father,point);break;
						case 9:test[point].is(temp.oprate('F','0'),father,point);break;
						case 10:test[point].is(temp.oprate('F','1'),father,point);break;
						case 11:test[point].is(temp.oprate('B','0'),father,point);break;
						case 12:test[point].is(temp.oprate('B','1'),father,point);break;*/
						case 1:temp.oprate('U','0');test[point].is(temp,father,point);break;
						case 2:temp.oprate('U','1');test[point].is(temp,father,point);break;
						case 3:temp.oprate('D','0');test[point].is(temp,father,point);break;
						case 4:temp.oprate('D','1');test[point].is(temp,father,point);break;
						case 5:temp.oprate('L','0');test[point].is(temp,father,point);break;
						case 6:temp.oprate('L','1');test[point].is(temp,father,point);break;
						case 7:temp.oprate('R','0');test[point].is(temp,father,point);break;
						case 8:temp.oprate('R','1');test[point].is(temp,father,point);break;
						case 9:temp.oprate('F','0');test[point].is(temp,father,point);break;
						case 10:temp.oprate('F','1');test[point].is(temp,father,point);break;
						case 11:temp.oprate('B','0');test[point].is(temp,father,point);break;
						case 12:temp.oprate('B','1');test[point].is(temp,father,point);break;
					}
					test[point].fa_nu=father;
					test[point].ow_nu=point;
					point=point+1;
					System.out.println(point);
					test[point-1].display();
				}
				father=father+1;
			}while(point<100);
			

	}	
}
	


