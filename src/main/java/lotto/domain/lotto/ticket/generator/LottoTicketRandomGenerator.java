package lotto.domain.lotto.ticket.generator;

import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.ticket.LottoTicket;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketRandomGenerator implements LottoTicketGenerator {

    @Override
    public LottoTicket generate() {
        List<LottoNumber> lottoNumberCandidates = IntStream.range(LottoNumber.MINIMUM_VALUE, LottoNumber.MAXIMUM_VALUE)
                .mapToObj(LottoNumber::from)
                .collect(Collectors.toList());
        Collections.shuffle(lottoNumberCandidates);
        return new LottoTicket(lottoNumberCandidates.subList(0, LottoTicket.LOTTO_NUMBERS_SIZE));
    }
}
