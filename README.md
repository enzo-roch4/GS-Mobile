# ChargeMap - Aplicativo de Planejamento para Carros Elétricos

ChargeMap é um aplicativo desenvolvido para auxiliar motoristas de veículos elétricos na identificação de pontos de recarga ao longo de suas viagens. Utilizando tecnologias de geolocalização e visão computacional, o aplicativo será capaz de exibir pontos de carga em um mapa interativo, oferecendo uma solução prática e acessível para o planejamento de viagens com carros elétricos.

## Funcionalidades do Aplicativo

### Tela Principal
A tela principal oferece uma interface inicial para o usuário navegar pelo sistema, com os seguintes elementos:
- **Botões de Acesso**: O menu contém botões para "Cadastro" e "Login", direcionando o usuário para as telas de autenticação ou registro.
- **Botão Planejar Viagem**: Abaixo do menu, o botão "Planejar viagem" leva o usuário à tela onde ele poderá planejar sua rota e identificar pontos de recarga ao longo do trajeto, especialmente útil em situações de emergência.

A interface do aplicativo é projetada para ser intuitiva e limpa, com cores suaves e contrastantes para destacar os elementos principais, facilitando a navegação.

### Tela de Cadastro e Login
A tela de cadastro permite que o usuário registre suas informações no sistema. Os campos disponíveis incluem:
- **Nome**: Campo de texto onde o usuário deve informar seu nome completo.
- **CPF**: Campo para inserir o CPF, garantindo que o cadastro seja único e seguro.
- **Modelo do Carro**: Informar o modelo do carro elétrico do usuário, essencial para a identificação dos pontos de recarga compatíveis.
- **Autonomia do Carro**: Informar a autonomia do carro (em quilômetros), o que ajudará no planejamento de viagens e na identificação de pontos de recarga no trajeto.

Após preencher todos os campos obrigatórios, o usuário clica em "Cadastrar" para salvar seus dados no sistema e acessa-lo pelo Login.

### Tela de Planejamento de Viagem
A tela de planejamento de viagem permite ao usuário definir um destino e visualizar os pontos de recarga disponíveis ao longo do trajeto. Esta tela inclui:
- **Campo de Destino**: O usuário insere seu destino (cidade, endereço ou ponto de interesse), o que permitirá ao aplicativo calcular a rota e identificar pontos de recarga no percurso.
- **Botão Planejar Viagem**: Após definir o destino, o botão "Planejar Viagem" inicia o processo de cálculo da rota e a busca por pontos de recarga.
- **Exibição de Pontos de Recarga**: A aplicação apresentará uma lista ou um mapa com os pontos de recarga ao longo do trajeto, exibindo a distância e a localização. Os pontos podem ser visualizados no mapa com ícones específicos para facilitar a navegação.

### Implementação de Visão Computacional
Nosso aplicativo contará com um modelo de visão computacional que será integrado ao mapa, permitindo a identificação automática de pontos de carga para veículos elétricos. Esse recurso adicionará uma camada de inteligência ao aplicativo, tornando-o ainda mais eficiente na localização de estações de recarga ao longo da rota.

## Tecnologias Utilizadas
- **Firebase**: Armazenamento de dados de usuários e informações de viagens.
- **Google Maps API**: Exibição de mapas e rotas com pontos de recarga.
- **Visão Computacional**: Identificação automática de estações de recarga.
- **Kotlin (Android)**: Linguagem principal para desenvolvimento Android.


