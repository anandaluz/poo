
class carro:
	def __init__(self):
		self.maxGasolina = 10
		self.tanque = 0
		carro.km = 0
		self.lugaresOcupados = 0
		self.maxLugaresOcupados = 2

	def __str__(self):
		return ("\npass: " + str(self.lugaresOcupados)  +
		", gas: " + str(self.tanque) +
		", km: " + str(self.km))
		
	def embarcar(self):
		if self.lugaresOcupados < self.maxLugaresOcupados:
			self.lugaresOcupados = self.lugaresOcupados+1
			return True 
		else:
			print ("fail: limite de pessoas atingido")
			
	def desembarcar(self):
		if self.lugaresOcupados > 0:
			self.lugaresOcupados = self.lugaresOcupados-1
			return True
		else:
			print ("fail: nao ha ninguem no carro")
		
	def abastecer(self, qtdGasolina):
		if self.tanque < self.maxGasolina:
			self.tanque = self.tanque+qtdGasolina
		if self.tanque > self.maxGasolina:
			self.tanque = self.maxGasolina 
			
	def dirigir(self, qtdKm):
		totalQuilometragem = self.tanque * 10 #quantos quilomntros o carro pode fazer com a gasolina atual do tanque
		gastoGasolina = qtdKm/10
		if((self.lugaresOcupados > 0) and (qtdKm <= totalQuilometragem)):
			self.km = self.km + qtdKm
			self.tanque = self.tanque - gastoGasolina
			return True
		elif qtdKm > totalQuilometragem:
			print ("fail: nao ha combustivel suficiente para realizar a viagem")
		if(self.lugaresOcupados  == 0): 
			print ("fail: nao ha ninguem para realizar a viagem")

			

		
		
		
		  
	
fusca = carro()# criando o objeto fusca da classe carro
#fusca.km = 8  # alterando o valor do atributo do objeto 

line = ""
print ("embarcar, desembarcar, abastecer, dirigir, show, end")
while (line!="end"):
	line = input()
	ui = line.split(" ")
	if ui[0] == "embarcar":
		fusca.embarcar()
	elif ui[0] == "desembarcar":
		fusca.desembarcar()
	elif ui[0] == "abastecer":
		fusca.abastecer(int(ui[1]))
	elif ui[0] == "dirigir":
		fusca.dirigir(int(ui[1]))
	elif ui[0] == "show":
		print(fusca)
	elif ui[0] == "end":
		break
	else:
		print ("comando invalido")
