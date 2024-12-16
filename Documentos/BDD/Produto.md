Funcionalidade:  Carrinho de compras
	
	Cenário: Adicionar um produto ao carrinho
		Dado que o usuário está na página do produto
		Quando o usuário escolhe um produto "Sauce Labs Bike Light"
		E o usuário clica no botão "ADD TO CART"
		Então o botão deverá mudar para "REMOVE" com cor de borda preta e o texto 'REMOVE'.
		E o sistema deverá exibir uma notificação no carrinho.
		
	Cenário: Remover um produto
		Dado que o usuário já adicionou um produto "Sauce Labs Bike Light" ao carrinho
		Quando o usuário clica no botão "REMOVE"	
		Então o botão deverá mudar para "ADD TO CART"
		E a notificação no icone do carrinho não deverá aparecer
		
	Cenário: Adicionar todos os produtos ao carrinho
		Dado que o usuário está na página do produto
		Quando o usuário clica no botão "ADD TO CART" todos os produtos
		Então os botões deverão mudar para "REMOVE"
		E a notificação no icone do carrinho com quantidade que selecionado
		
	Cenário: Remover produto após Adicionar e acessar a página de detalhes
		Dado que o usuário já clicou no botão "ADD TO CART" para o produto "Sauce Labs Bike Light"
		Quando o usuário clica no produto "Sauce Labs Bike Light" para acessar sua página de detalhes
		E na página de detalhes, clica no botão "REMOVE"
		E clica no botão "BACK" para retornar página do produto
		Então para o produto "Sauce Labs Bike Light" o botão deverá mudar para "ADD TO CART"
		E a notificação no icone do carrinho não deverá aparecer

Funcionalidade:  Ordenação de produtos
		
	Cenário: Ordenar produtos na página produto (Z ao A)
		Dado que o usuário está na página do produto e verifica se organização de produtos por nome
		Quando o usuário clica no Select "Name(A to Z)"
		E aparecer a lista de opções "Name (A to Z)", "Name (Z to A)", "Price (low to high)" e "Price (high to low)"
		E o usuário seleciona "Name (Z to A)"
		Então os produtos deverão ser reorganizados na página em ordem decrescente de Z para A
		
	Cenário: Ordenar produtos na página produto (menor ao maior)
		Dado que o usuário está na página do produto e verifica se organização de produtos por preço
		Quando o usuário clica no Select "Name(A to Z)"
		E aparecer a lista de opções "Name (A to Z)", "Name (Z to A)", "Price (low to high)" e "Price (high to low)"
		E o usuário seleciona "Price (low to high)"
		Então os produtos deverão ser reorganizados na página do menor para o maior preço
		
	Cenário: Ordenar produtos na página produto (maior ao menor)
		Dado que o usuário está na página do produto e verifica se organização de produtos por preço
		Quando o usuário clica no Select "Name(A to Z)"
		E aparecer a lista de opções "Name (A to Z)", "Name (Z to A)", "Price (low to high)" e "Price (high to low)"
		E o usuário seleciona "Price (high to low)"
		Então os produtos deverão ser reorganizados na página do maior para o menor preço
		
Funcionalidade:  Ações do menu

	Cenário: Opção do menu "All Items"
		Dado que o usuário está na página do produto e verifica do menu
		Quando o usuário clica no ícone ou símbolo de três linhas
		E aparece uma lista de opções: "All Items", "About", "Logout", "Reset App State" e "X"
		E o usuário clica "All Items"
		Então o sistema deverá redirecionar para a tela principal com a lista de produtos
	
	Cenário: Opção do menu "About"
		Dado que o usuário está na página do produto e verifica do menu
		Quando o usuário clica no ícone ou símbolo de três linhas
		E aparece uma lista de opções: "All Items", "About", "Logout", "Reset App State" e "X"
		E o usuário clica "About"
		Então o sistema deverá redirecionar para site de "SauceLabs"
		
	Cenário: Opção do menu "Logout"
		Dado que o usuário está na página do produto e verifica do menu
		Quando o usuário clica no ícone ou símbolo de três linhas
		E aparece uma lista de opções: "All Items", "About", "Logout", "Reset App State" e "X"
		E o usuário clica "Logout"
		Então o sistema deverá redirecionar para a tela de login, deslogando o usuário
		
	Cenário: Opção do menu "Reset App State"
		Dado que o usuário está na página do produto e verifica do menu
		Quando o usuário escolhe um produto "Sauce Labs Bike Light"
		E o usuário clica no botão "ADD TO CART"
		E o botão deverá mudar para "REMOVE" com cor de borda preta e o texto 'REMOVE'
		E o sistema deve exibir uma notificação no carrinho
		E o usuário clica no ícone ou símbolo de três linhas
		E aparece uma lista de opções: "All Items", "About", "Logout", "Reset App State" e "X"
		E o usuário clica "Reset App State"
		Então O sistema deverá remover a notificação do carrinho
		E o botão deverá voltar para "ADD TO CART"
		
	Cenário: Opção do menu "X"
		Dado que o usuário está na página do produto e verifica do menu
		Quando o usuário clica no ícone ou símbolo de três linhas
		E aparece uma lista de opções: "All Items", "About", "Logout", "Reset App State" e "X".
		E o usuário clica "X"
		Então o menu deverá fechar