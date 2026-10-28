package br.com.aula.clean.frameworks;

import br.com.aula.clean.usecases.ProcessarNovoPedido;
import br.com.aula.clean.usecases.ports.PedidoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {

    @Bean
    ProcessarNovoPedido processarNovoPedido(PedidoRepository repository) {
        return new ProcessarNovoPedido(repository);
    }
}
