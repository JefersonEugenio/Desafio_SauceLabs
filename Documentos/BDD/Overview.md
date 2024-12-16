Funcionalidade: Finalização de compra

	Cenário: Finalizar compra com produto no carrinho
		Dado que o usuário está na página de "Overview"
		Quando o usuário verifica um produto listado na página de Overview
		E o usuário verifica o valor do produto listado na página de Overview
		E o usuário verifica do item total, taxa e total listado na página de Overview
		E o usuário clica no botão "FINISH"
		Então o sistema deverá redirecionar para a tela de confirmação (Finish) exebindo a mensagem "THANK FOR YOUR ORDER"
		
	Cenário: Cancelar e retornar a tela principal
		Dado que o usuário está na página de "Overview"
		Quando o usuário clica no botão "CANCEL"
		Então o sistema deverá redirecionar para a tela principal com a lista de produtos