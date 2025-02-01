package app.web.mymoney.repositories;

import app.web.mymoney.entities.Launch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LaunchRepository extends JpaRepository<Launch, Long> {

    @Query(value = """
        SELECT 
            SUM(CASE WHEN type_moviment = 'INCOME' THEN amount ELSE 0 END) AS totalIncome,
            SUM(CASE WHEN type_moviment = 'EXPENSE' THEN amount ELSE 0 END) AS totalExpense,
            SUM(CASE WHEN type_moviment = 'INCOME' THEN amount ELSE 0 END) -
            SUM(CASE WHEN type_moviment = 'EXPENSE' THEN amount ELSE 0 END) AS balance
        FROM launch
        WHERE user_id = :userId AND payment_date BETWEEN :startDate AND :endDate
    """, nativeQuery = true)
    List<Object[]> findBalanceByUserAndDate(@Param("userId") Long userId,@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query(value = "WITH years AS ( " +
            "    SELECT generate_series( " +
            "        (SELECT MIN(EXTRACT(YEAR FROM payment_date)::INTEGER) FROM launch where user_id = :userId), " +
            "        (SELECT MAX(EXTRACT(YEAR FROM payment_date)::INTEGER) FROM launch where user_id = :userId) " +
            "    ) AS year " +
            ") " +
            "SELECT year FROM years " +
            "ORDER BY year", nativeQuery = true)
    List<Integer> findDistinctYears(@Param( "userId") Long userId);
}
