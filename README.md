# Chatapp
Chat criado com a linguagem de programação Java, utilizando Sockets para conexão e Swing para interface gráfica.

-O projeto foi testado nas IDEs Netbeans 8.2 e Eclipse, então pode ser que você usuário queira utilizar algumas dessas IDEs.

Requisitos:
	-Ter o Java Development Kit(JDK) instalado

Instruções:
	-A classe TelaServidor requisita que uma porta seja selecionada uma porta
	 para que a comunicação funcione(linha 143);
	-A classe TelaCliente requisita que a porta seja a mesma, além disso 
	 nessa classe é necessário colocar o endereço de IP do servidor;
	 Caso esteja rodando no mesmo computador coloque 127.0.0.1 ou localhost, 
	 caso esteja rodando em computadores diferentes coloque o IP do 
	 computador servidor, a comunicação funciona tanto por wi-fi, quanto por
	 cabo de par trançado/Ethernet(linha 168);
	-SEMPRE execute TelaServidor antes de TelaCliente;
	-Existe um arquivo de backup que grava as mensagens enviadas e recebidas,
	 caso você esteja executando o projeto na mesma máquina, as mensagens do 
	 cliente e do servidor serão gravadas no mesmo arquivo. Caso queira
	 alterar o diretório de arquivo, vá até a classe EntradaSaida e altere o
	 caminho no construtor da classe Backup.
