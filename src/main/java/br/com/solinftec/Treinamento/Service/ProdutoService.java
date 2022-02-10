package br.com.solinftec.Treinamento.Service;

import br.com.solinftec.Treinamento.dto.produto.ProdutoDto;
import br.com.solinftec.Treinamento.dto.produto.SaveProdutoDto;
import br.com.solinftec.Treinamento.model.Produto;
import br.com.solinftec.Treinamento.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProdutoService {
    private final ProdutoRepository repository;

    public List<ProdutoDto> getAllProdutos() {
        return repository.findAll()
                .stream()
                .map(produto -> new ProdutoDto(produto))
                .collect(Collectors.toList());
    }


    public SaveProdutoDto saveProduto(SaveProdutoDto saveprodutoDto) {
        Produto produto = saveprodutoDto.pegarModelPR();
        repository.save(produto);
        saveprodutoDto.setId(produto.getId());
        return saveprodutoDto;
    }

    public SaveProdutoDto updateProduto(SaveProdutoDto saveProdutoDto) throws Exception {

        Optional<Produto> produto = repository.findById(saveProdutoDto.getId());

        if(produto.isPresent()) {
            repository.save(saveProdutoDto.pegarModelPR());
            return saveProdutoDto;
        } else {
            throw new Exception("PRODUTO_NOT_FOUND");
        }
    }

    public void deletarProduto(Long idProduto) throws Exception {

        Optional<Produto> produto = repository.findById(idProduto);

        if(produto.isPresent()) {
            repository.delete(produto.get());
        } else {
            throw new Exception("PRODUTO_NOT_FOUND");
        }
    }


}