package br.edu.fatecpg.atv6;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();

        funcionarios.add(new Funcionario("Maria Clara", "TI", 2000, 1));
        funcionarios.add(new Funcionario("Maria Vitoria", "TI", 2200, 2));
        funcionarios.add(new Funcionario("Bianca", "TI", 2400, 3));
        funcionarios.add(new Funcionario("Julya", "Marketing", 3000, 4));
        funcionarios.add(new Funcionario("Juliana", "Marketing", 3200, 11));
        funcionarios.add(new Funcionario("Ana Julia", "Marketing", 3400, 12));
        funcionarios.add(new Funcionario("Monica", "Rh", 4000, 13));
        funcionarios.add(new Funcionario("Laura", "Rh", 4200, 14));

        funcionarios.forEach(System.out::println);

        System.out.println(" ");

        funcionarios.stream().filter(f -> f.getSalario() > 3000)
                .forEach(System.out::println);

        System.out.println(" ");

        List<Funcionario> atualizados = funcionarios.stream()
                .map(f -> {
                    if (f.getAnosDeServico() > 10) {
                        f.setSalario(f.getSalario() * 1.05);
                    }
                    return f;
                })
                .toList();

        atualizados.forEach(System.out::println);

        System.out.println(" ");

        funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .forEach(System.out::println);

        System.out.println(" ");

        double totalSalarios = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(0.0, (acc, salario) -> acc + salario);

        System.out.println("Total de salários: R$ " + totalSalarios);

        System.out.println(" ");

        Map<String, Double> mediaPorDepto = funcionarios.stream()
                .collect(Collectors.groupingBy(
                        Funcionario::getDepto,
                        Collectors.averagingDouble(Funcionario::getSalario)
                ));

        System.out.println(" ");

        mediaPorDepto.forEach((depto, media) ->
                System.out.println("Departamento: " + depto +
                        " | Média Salarial: R$ " + media)
        );

        System.out.println(" ");

        Funcionario maisAntigo = funcionarios.stream()
                .max((f1, f2) -> Integer.compare(f1.getAnosDeServico(), f2.getAnosDeServico()))
                .orElse(null);

        System.out.println("Funcionário mais antigo: " + maisAntigo);

        System.out.println(" ");

        funcionarios.forEach(f ->
                System.out.println(
                        "Funcionário: " + f.getNome() +
                                ", Departamento: " + f.getDepto() +
                                ", Salário: R$ " + f.getSalario()
                )
        );
    }
}
