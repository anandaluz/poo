
	import java.util.Scanner;

	public class Carro {
		float tanque; // atributo p uma numeracao do tipo inteiro //
		float maxtanque;
		int qtdpass; 
		int maxqtdpass;
		float km; 
		
		public Carro() { // construtor do carro 
			tanque = (float) 0.0;
			maxtanque = (float) 10.0;
			maxqtdpass = 2;
			qtdpass = 0;
			km = (float) 0.0;
		}
		
		public void show() {
			System.out.println("pass:" +qtdpass+ ", gas:" +tanque+  ", km:"+km);
		}
		public void embarcar(){
			if (qtdpass < maxqtdpass) {
				qtdpass += 1;
			}else{
				System.out.println("fail: limite de pessoas atingido");
			}
			
		}
		public void desembarcar() {
			if (qtdpass > 0) {
				qtdpass -= 1;
			}else{
				System.out.println("fail: nao ha ninguem dentro do carro");
			}
		}
		public void abastecer(float qtdgasolina) {
			if (tanque < maxtanque) {
				tanque += qtdgasolina;
				if (tanque > maxtanque) {
					tanque = maxtanque;
				}
			}
		}
		
		public void dirigir(float qtdkm) {
			float gastogasolina;
			gastogasolina = qtdkm / 10;
			if((qtdpass > 0) && (gastogasolina <= tanque)){
				tanque -= gastogasolina;
				km += qtdkm;
			}else if(gastogasolina > tanque) {
				System.out.println("fail: gasolina insuficiente");
				
			}else if(qtdpass <= 0) {
				System.out.println("fail: o carro nao tem ninguem");
			}
			
		}
		
		public static void main(String[] args) {
			Carro fusca = new Carro(); // criando objeto ou instanciando um objeto//
			Scanner input = new Scanner(System.in);
			boolean entrar = true;
			System.out.println("embarcar, desembarcar, abastecer valor, dirigir valor, sair");
			while(entrar) {
				String linha = input.nextLine();
				String[] comando = linha.split(" ");
				String op = comando[0];
				if(op.equals("embarcar")) {
					fusca.embarcar();
				}else if(op.equals("desembarcar")) {
					fusca.desembarcar();		
				}else if(op.equals("show")){
					fusca.show();				
				}else if(op.equals("abastecer")) {
					float qtdgasolina = Float.parseFloat(comando[1]);
					fusca.abastecer(qtdgasolina);
				}else if(op.equals("dirigir")) {
					float qtdkm = Float.parseFloat(comando[1]);
					fusca.dirigir(qtdkm);
				}else if(op.equals("sair")) {	
					entrar = false;
				}
			}
		}
	}


