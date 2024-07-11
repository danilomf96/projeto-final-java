# projeto-final-java -> Hero of World
O Projeto serviu como avaliação semestral sobre o conteudo aprendido em sala de aula, como orientação a objetos, salvar arquivos, heranças, polimorfismo. Seguindo conceitos de Clean Code, separando os pacotes para melhor entendimento do codigo
# O Jogo
Um jogo de turnos, onde voce seleciona suas açoes durante o combate. Acumule ouro para fortalecer seu Herói no Mercador 
## Menu
Dentro do jogo, voce encontrara as opções de Criar Usuario ou Fazer Login
# Estrutura
Utilizando apenas arquivos txt, fazemos um cadastro de usuarios, que serao salvos em apenas um txt.
##Pastas
Dentro da Pasta Usuarios, temos a classe Usuario.java e UsuarioPersistencia.java, este responsavel pela criaçao do arquivo de login.
####Personagens
Dentro da Pasta Personagens, temos a classe abstrata Personagem.java, classe que é herdada pela Heroi.java e Vilao.java.
####Personagem Persistencia
Dentro deste arquivo temos uma das principais logicas do programa, que é a criaçao do personagem dependendo diretamente do arquivo criado no UsuarioPersistencia.java, para localizar o usuario e criar um txt especifico para os herois daquele usuario.
###Batalha
Com vilões estaticos, a batalha serve para voce acumular ouro, os inimigos sao aleatorios, entao cuidado com quem enfrentará. Jogue com cautela suas batalhas, defenda os golpes dos inimigos e ataque com suas magias para um dano maior.
###Comerciante
Acumulando Ouro, voce pode aumentar os status do seu Herói fazendo uma troca com Bob, o comerciante.
