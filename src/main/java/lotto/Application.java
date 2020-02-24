package lotto;

import lotto.domain.*;
import lotto.utils.LottoFactory;
import lotto.utils.NumberGenerator;
import lotto.utils.UserInputNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final Payment payment = generatePayment();
        OutputView.printLottoCount(payment);

        final LottoTickets lottoTickets = LottoFactory.createLottoList(payment);
        OutputView.printLottoList(lottoTickets);

        final WinningLottoTicket winningLotto = generateWinningLotto();
        OutputView.printResults(new Results(lottoTickets, winningLotto));
    }

    private static Payment generatePayment() {
        try {
            return new Payment(InputView.getPayment());
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception
                    .getMessage());
            return generatePayment();
        }
    }

    private static WinningLottoTicket generateWinningLotto() {
        NumberGenerator numberGenerator = new UserInputNumberGenerator();
        try {
            return new WinningLottoTicket(numberGenerator.generateNumbers(InputView
                    .getWinningLottoNumber()), new LottoNumber(InputView
                    .getBonusNumber()));
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception
                    .getMessage());
            return generateWinningLotto();
        }
    }
}
