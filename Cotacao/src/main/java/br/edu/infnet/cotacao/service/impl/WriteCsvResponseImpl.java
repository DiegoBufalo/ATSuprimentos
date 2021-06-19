package br.edu.infnet.cotacao.service.impl;

import static com.opencsv.ICSVWriter.NO_QUOTE_CHARACTER;

import java.io.PrintWriter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvException;

import br.edu.infnet.cotacao.dto.CotacaoDto;
import br.edu.infnet.cotacao.service.WriteCsvResponse;

@Service
public class WriteCsvResponseImpl implements WriteCsvResponse{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WriteCsvResponseImpl.class);

	@Override
	public void writeCotacoes(PrintWriter writer, CotacaoDto cotacao) {
        try {

            ColumnPositionMappingStrategy<CotacaoDto> mapStrategy
                    = new ColumnPositionMappingStrategy<>();

            mapStrategy.setType(CotacaoDto.class);

            var columns = new String[]{"id", "preco", "idProduto", "fornecedor", "data_cotacao", "validade_cotacao"};
            mapStrategy.setColumnMapping(columns);

            StatefulBeanToCsv<CotacaoDto> btcsv = new StatefulBeanToCsvBuilder<CotacaoDto>(writer)
                    .withQuotechar(NO_QUOTE_CHARACTER)
                    .withMappingStrategy(mapStrategy)
                    .withSeparator(',')
                    .build();

            btcsv.write(cotacao);

        } catch (CsvException ex) {

            LOGGER.error("Error mapping Bean to CSV", ex);
        }
    }
	
	@Override
	public void writeCotacoes(PrintWriter writer, List<CotacaoDto> cotacoes) {
        try {

            ColumnPositionMappingStrategy<CotacaoDto> mapStrategy
                    = new ColumnPositionMappingStrategy<>();

            mapStrategy.setType(CotacaoDto.class);

            var columns = new String[]{"id", "preco", "idProduto", "fornecedor", "data_cotacao", "validade_cotacao"};
            mapStrategy.setColumnMapping(columns);

            StatefulBeanToCsv<CotacaoDto> btcsv = new StatefulBeanToCsvBuilder<CotacaoDto>(writer)
                    .withQuotechar(NO_QUOTE_CHARACTER)
                    .withMappingStrategy(mapStrategy)
                    .withSeparator(',')
                    .build();

            btcsv.write(cotacoes);

        } catch (CsvException ex) {

            LOGGER.error("Error mapping Bean to CSV", ex);
        }
	}
}
