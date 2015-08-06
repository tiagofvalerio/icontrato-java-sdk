#Como integrar o icontrato-java-sdk com sua aplicação:
======

Para integrar o iContrato em sua aplicação e enviar documentos para assinatura ou aprovação, basta implementar as chamadas necessárias como no exemplo abaixo, inserindo as informações reais nos campos iniciados com #.

	private IContratoService service = new IContratoService("#USUARIO", "#SENHA");

	DocumentBuilder documentBuilder = new DocumentBuilder()
		.withDocument("#NOME_ARQUIVO_PDF", INPUT_STREAM_DO_DOCUMENTO)
		.withStep("#CPF_PARTE", "#NOME_PARTE",
			"#EMAIL_PARTE", "#DESCRICAO_PARTE",
				#ACAO_PARTE, "#PAPEL_PARTE");

	service.SendDocument(documentBuilder);


#Observações:
======

- A instância da classe IContratoService deve receber o usuário e senha do usuário cadastrado no portal iContrato.

- O documento deve ser criado pelo método "withDocument", passando-se o nome do arquivo PDF e seu conteúdo em um input stream.

- Os steps (partes que irão assinar ou aprovar o documento) devem ser criados com o método "withStep", passando-se o cpf, o nome, o e-mail, a descrição, a ação e o papel da parte.

- Podem ser criados quantos steps forem necessários.

- A ação de cada step consiste de um enum ActionType e pode ser SIGN(Assinar) ou APPROVE (aprovar).


O cadastro pode ser efetuado em http://icontrato.idtrust.com.br

            