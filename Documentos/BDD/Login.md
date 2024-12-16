Funcionalidade: Login no sistema Swag Labs

	Contexto:
		Dado que o usuário está na página de login do sistema Swag Labs

	Cenário: Login com válidas
		Quando o usuário preenche o campo "Username" com "standard_user"
		E o usuário preenche o campo "Password" com "secret_sauce"
		E o usuário clica no botão "LOGIN"
		Então o sistema autentica o usuário
		E redireciona para a tela principal
		
	Cenário: Login com campos vazios (sem username e password)
		Quando o usuário deixa o campo "Username" em branco
		E o usuário deixa o campo "Password" em branco
		E o usuário clica no botão "LOGIN"
		Então o sistema exibe a mensagem "Username is required"
		
	Cenário: Login com campo vazio (sem password)
		Quando o usuário preenche o campo "Username" com "standard_user"
		E o usuário deixa o campo "Password" em branco
		E o usuário clica no botão "LOGIN"
		Então o sistema exibe a mensagem "Password is required"
		
	Cenário: Login com campo vazio (sem username)
		Quando o usuário deixa o campo "Username" em branco
		E o usuário preenche o campo "Password" com "secret_sauce"
		E o usuário clica no botão "LOGIN"
		Então o sistema exibe a mensagem "Username is required"
		
	Cenário: Login com invalida (username incorreto)
		Quando o usuário preenche o campo "Username" com "qwert"
		E o usuário preenche o campo "Password" com "secret_sauce"
		E o usuário clica no botão "LOGIN"
		Então o sistema exibe a mensagem "Username and password do not match any user in this service"
		
	Cenário: Login com invalida (password incorreto)
		Quando o usuário preenche o campo "Username" com "standard_user"
		E o usuário preenche o campo "Password" com "1234567890"
		E o usuário clica no botão "LOGIN"
		Então o sistema exibe a mensagem "Username and password do not match any user in this service"
		
	Cenário: Login com invalida (username e password incorreto)
		Quando o usuário preenche o campo "Username" com "qwert"
		E o usuário preenche o campo "Password" com "1234567890"
		E o usuário clica no botão "LOGIN"
		Então o sistema exibe a mensagem "Username and password do not match any user in this service"
		
	Cenário: Login com usuário bloqueado
		Quando o usuário preenche o campo "Username" com "locked_out_user"
		E o usuário preenche o campo "Password" com "secret_sauce"
		E o usuário clica no botão "LOGIN"
		Então o sistema exibe a mensagem "Sorry, this user has been locked out."
		
	Cenário: Login com válida (usuário problemático)
		Quando o usuário preenche o campo "Username" com "problem_user"
		E o usuário preenche o campo "Password" com "secret_sauce"
		E o usuário clica no botão "LOGIN"
		Então o sistema autentica o usuário
		E redireciona para a tela principal