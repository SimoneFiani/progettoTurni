package it.fiani.progettoTurni.utility;

import java.time.OffsetDateTime;

import lombok.Data;

@Data
public class DataUtility {

	private OffsetDateTime istanteInizioA;
	private OffsetDateTime istanteFineA;
	private OffsetDateTime istanteInizioB;
	private OffsetDateTime istanteFineB;

	public static boolean iPeriodiSiSovrappongono(OffsetDateTime istanteInizioA, OffsetDateTime istanteFineA,
			OffsetDateTime istanteInizioB, OffsetDateTime istanteFineB) {

		return periodoAContienePeriodoB(istanteInizioA, istanteFineA, istanteInizioB, istanteFineB)
				|| periodoBcontienePeriodoA(istanteInizioA, istanteFineA, istanteInizioB, istanteFineB)
				|| periodoAfinisceInPeriodoB(istanteInizioA, istanteFineA, istanteInizioB, istanteFineB)
				|| periodoBfinisceInPeriodoA(istanteInizioA, istanteFineA, istanteInizioB, istanteFineB);

	}

	private static boolean periodoBfinisceInPeriodoA(OffsetDateTime istanteInizioA, OffsetDateTime istanteFineA,
			OffsetDateTime istanteInizioB, OffsetDateTime istanteFineB) {

		return istanteInizioB.isBefore(istanteInizioA) && istanteFineB.isBefore(istanteFineA);
	}

	private static boolean periodoAfinisceInPeriodoB(OffsetDateTime istanteInizioA, OffsetDateTime istanteFineA,
			OffsetDateTime istanteInizioB, OffsetDateTime istanteFineB) {

		return istanteInizioA.isBefore(istanteInizioB) && istanteFineA.isBefore(istanteFineB);

	}

	private static boolean periodoBcontienePeriodoA(OffsetDateTime istanteInizioA, OffsetDateTime istanteFineA,
			OffsetDateTime istanteInizioB, OffsetDateTime istanteFineB) {

		return istanteInizioB.isBefore(istanteInizioA) && istanteFineB.isAfter(istanteFineA);
	}

	private static boolean periodoAContienePeriodoB(OffsetDateTime istanteInizioA, OffsetDateTime istanteFineA,
			OffsetDateTime istanteInizioB, OffsetDateTime istanteFineB) {

		return istanteInizioA.isBefore(istanteInizioB) && istanteFineA.isAfter(istanteFineB);
	}

}
