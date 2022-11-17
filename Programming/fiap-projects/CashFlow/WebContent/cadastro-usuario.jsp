<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">


<!-- Minha CSS -->
<link rel="stylesheet" href="./Assests/css/style2.css">

<link rel="shortcut icon"
	href="/Assests/imagens/0- Cash Flow - Icone.svg" type="image/x-icon">
<title>Login CF</title>


</head>

<body class="text-center">
	<main>
	<div class="container-fluid text-center mt-5">
		<div class="row">

			<!-- Primeira Coluna -->
			<div class="col-md-4">
				<img src="./Assests/imagens/10- BitcoinP2P-pana.svg"
					class="img-fluid" alt="">
			</div>

			<!-- Segunda Coluna -->
			<div class="coluna2 col-md-4 my-4 p-4">
				<div class="m-2 p-4">
					<img class="mb-4" src="./Assests/imagens/1- Cash Flow - Logo 1.svg"
						alt="" width="72" height="57">
					<form>
						<button class="btn btn-lg btn-warning btn-outline-dark m-3"
							type="button" onclick="loginMenuClick()">Entrar</button>
						<button class="btn btn-lg btn-warning btn-outline-dark m-3"
							type="button" onclick="cadastroMenuClick()">Cadastrar</button>

						<div id="menuLogin">
							<div class="form-floating">
								<input type="text" class="form-control" id="emailLogin"
									placeholder=""> <label for="floatingInput">Seu
									e-mail</label>
							</div>
							<div class="form-floating">
								<input type="password" class="form-control" id="senhaLogin"
									placeholder=""> <label for="floatingPassword">Senha</label>
							</div>
							<div class="checkbox m-3">
								<label> <input type="checkbox" value="remember-me">
									Lembrar-me
								</label>
							</div>
							<button class="w-100 btn btn-lg btn-dark" type="submit">Entrar</button>
						</div>

						<div id="menuCadastro" style="display: none">
							<div class="form-floating">
								<input type="text" class="form-control mt-3 mb-4" id="nm_user"
									placeholder=""> <label for="nm_user">Nome</label>
							</div>
							<div class="form-floating">
								<input type="text" class="form-control mb-4" id="cpf_user"
									placeholder="" onclick="mascara(i)"> <label
									for="cpf_user">CPF</label>
							</div>
							<div class="form-floating">
								<input type="text" class="form-control mb-4" id="ds_user_email"
									placeholder=""> <label for="ds_user_email">E-mail</label>
							</div>

							<div class="form-floating">
								<input type="password" class="form-control mb-4"
									id="senhaCadastro" placeholder=""> <label
									for="floatingPassword">Senha</label>
							</div>
							<div class="form-floating">
								<input type="password" class="form-control mb-4"
									id="confirmSenha" placeholder=""> <label
									for="floatingPassword">Confirmar Senha</label>
							</div>
							<div class="checkbox m-3">
								<label> <input type="checkbox" value="remember-me">
									Lembrar-me
								</label>
							</div>
							<button class="w-100 btn btn-lg btn-dark" type="submit">Cadastrar</button>
						</div>
						<p class="mt-5 mb-3 text-muted">© 2022</p>
					</form>
				</div>
			</div>

			<!-- Terceira Coluna -->
			<div class="col-md-4">
				<img src="./Assests/imagens/11- Savings-bro.svg" class="img-fluid"
					alt="">
			</div>
		</div>
	</div>
	</div>
	</main>

	<!-- Javascript -->
	<script src="/Projeto Fintech/Assests/Javascript/app.js"></script>
</body>

</html>