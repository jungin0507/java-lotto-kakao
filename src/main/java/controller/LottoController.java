package controller;

import domain.lotto.*;
import view.LottoInputView;
import view.LottoOutputView;

import java.util.List;

public class LottoController {

    private final LottoInputView lottoInputView = new LottoInputView();
    private final LottoOutputView lottoOutputView = new LottoOutputView();
    private final LottoShop lottoShop = new LottoShop(new LottoTicketRandomGenerator());

    public void startLotto() {
        Cost cost = lottoInputView.readCost();
        List<LottoTicket> lottoTickets = lottoShop.buyLottoTickets(cost);
        lottoOutputView.printLottoTickets(lottoTickets);
        LottoWinningNumber lottoWinningNumber = lottoInputView.readWinningNumber();
        LottoResultCalculator lottoResultCalculator = new LottoResultCalculator(lottoTickets, lottoWinningNumber);
        lottoOutputView.printLottoResult(lottoResultCalculator.calculateLottoResult());
    }
}