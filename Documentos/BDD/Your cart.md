Funcionalidade: A página do carrinho
		
	Cenário: Remover produto do carrinho
		Dado que o usuário está na página do carrinho e quer remover o produto  
		Quando o usuário clica no botão "REMOVE"
		Então a notificação no icone do carrinho desaparece
		E a lista do produto desaparece
		
	Cenário: Continuar comprando pelo carrinho
		Dado que o usuário está na página do carrinho e quer continuar a fazer compras
		Quando o usuário clica no botão "CONTINUE SHOPPING"
		Então o sistema deverá redirecionar para a tela principal com produtos
		
	Cenário: Ir para checkout pelo carrinho
		Dado que o usuário está na página do carrinho e deseja avaçar para o checkout
		Quando o usuário clica no botão "CHECKOUT"
		Então o sistema deverá redirecionar para a tela	de informações (checkout)