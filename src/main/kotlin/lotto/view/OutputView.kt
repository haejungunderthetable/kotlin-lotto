package lotto.view

import lotto.model.Lotto
import lotto.model.LottoRank
import lotto.model.LottoStatisticFormat

/**
 * 로또 관련된 결과를 알려주는 클래스
 * */
class OutputView {
    fun resultLottoCount(count: Int) {
        println("${count}개를 구매했습니다.")
    }

    // 로또 당첨 번호 출력
    fun printNumber(lottos: List<Lotto>) {
        lottos
            .forEach { lottoNumber ->
                println("[${lottoNumber.numbers.map { it.number }.joinToString()}]")
            }
        println("")
    }

    fun printWinStatistic(result: LottoStatisticFormat) {
        println("당첨 통계")
        println("---------")
        printRankingList(result)
        println("총 수익률은 ${result.profit}입니다.")
    }

    private fun printRankingList(result: LottoStatisticFormat) {
        LottoRank.values()
            .filter { it != LottoRank.MISS }
            .sortedBy { it.countOfMatch }
            .forEach { rank ->
                println("${rank.countOfMatch}개 일치 (${rank.winningMoney})- ${result.winList[rank] ?: 0}개")
            }
    }
}