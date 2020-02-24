package lotto.view;

import lotto.domain.*;

import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

public class OutputView {
    public static void printLottoCount(final Payment payment) {
        System.out.println(payment.getLottoCount() + "개를 구매했습니다");
    }

    public static void printLottoList(final LottoTickets lottoTickets) {
        List<LottoTicket> lottoTicketList = lottoTickets.getLottoTickets();
        for (int i = 0; i < lottoTicketList.size(); i++) {
            System.out.println(lottoTicketList
                    .get(i)
                    .getLottoNumbers()
                    .toString());
        }
    }

    public static void printResults(final Results results) {
        TreeMap<WinningInfo, Long> summary = new TreeMap<>(results.getSummary());
        Iterator<WinningInfo> iteratorKey = summary.keySet()
                .iterator();

        System.out.println("\n당첨 통계");
        System.out.println("---------");

        while (iteratorKey.hasNext()) {
            WinningInfo key = iteratorKey.next();

            System.out.println(winningString(key) + (summary.get(key) - 1) + "개");
        }
        System.out.println("총 수익률을 " + results.getEarningRate() + "%입니다.");
    }

    public static String winningString(final WinningInfo key) {
        String bonusString = "";
        if (key.hasBonus()) {
            bonusString = ", 보너스 볼 일치";
        }
        return key.getWinningCount() + "개 일치" + bonusString + "(" + key.getWinningPrice() + "원)- ";
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
