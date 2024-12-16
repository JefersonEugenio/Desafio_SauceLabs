Funcionalidade: Funciona e as informações dados na página do "checkout"
		
	Cenário: Preenchimento completo e válido
		Dado que o usuário está na página do checkout
		Quando o usuário preenche o campo "First Name" com o nome
		E o usuário preenche o campo "Last Name" com o nome
		E o usuário preenche o campo "Zip/Postal" com o número
		E o usuário clica no botão "CONTINUE"
		Então o sistema deverá redirecionar para a página "Overview"
		
	Cenário: Campo "First Name" em branco
		Dado que o usuário está na página do checkout
		Quando o usuário não preenche o campo "First Name"
		E o usuário preenche o campo "Last Name" com o nome  
		E o usuário preenche o campo "Zip/Postal" com o número  
		E o usuário clica no botão "CONTINUE"
		Então O sistema exibirá a mensagem: "Error: First Name is required"
		
	Cenário: Campo "Last Name" em branco
		Dado que o usuário está na página do checkout
		Quando o usuário preenche o campo "First Name" com o nome  
		E o usuário não preenche o campo "Last Name"
		E o usuário preenche o campo "Zip/Postal" com o número  
		E o usuário clica no botão "CONTINUE"
		Então O sistema exibirá a mensagem: "Error: Last Name is required"
		
	Cenário: Campo "Zip/Postal" em branco
		Dado que o usuário está na página do checkout
		Quando o usuário preenche o campo "First Name" com o nome  
		E o usuário preenche o campo "Last Name" com o nome  
		E o usuário não preenche o campo "Zip/Postal"
		E o usuário clica no botão "CONTINUE"
		Então O sistema exibirá a mensagem: "Error: Postal Code is required"
		
	Cenário: Todos os campos em branco
		Dado que o usuário está na página do checkout
		Quando o usuário não preenche o campo "First Name"
		E o usuário não preenche o campo "Last Name"
		E o usuário não preenche o campo "Zip/Postal"
		E o usuário clica no botão "CONTINUE"
		Então O sistema exibirá a mensagem: "Error: First Name is required"
		
	Cenário: Cancelar e retornar ao carrinho
		Dado que o usuário está na página do checkout e deseja clicar cancelar
		Quando o usuário clica no botão "CANCEL"
		Então o sistema deverá redirecionar para a tela do carrinho 