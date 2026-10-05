package algorithms.graph.bipartite;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Bipartite projection
 *
 * Fraud graphs are often two sides: accounts and identifiers (device,
 * card, address). An edge means "this account uses that identifier".
 * Projecting the graph links accounts that share an identifier, which
 * is the pattern analysts look for.
 *
 * This test links alice and bob through one phone. carol's tablet does
 * not join them.
 */
class BipartiteTest {

    @Test
    void linksAccountsThatShareADevice() {
        Map<String, List<String>> uses = Map.of(
                "alice", List.of("phone-1", "laptop"),
                "bob", List.of("phone-1"),
                "carol", List.of("tablet"));

        Set<String> pairs = sharedAccounts(uses);

        assertEquals(Set.of(pair("alice", "bob")), pairs);
        assertTrue(pairs.stream().noneMatch(link -> link.contains("carol")));
    }

    private Set<String> sharedAccounts(Map<String, List<String>> accountToDevices) {
        Map<String, List<String>> deviceToAccounts = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : accountToDevices.entrySet()) {
            for (String device : entry.getValue()) {
                deviceToAccounts.computeIfAbsent(device, key -> new ArrayList<>()).add(entry.getKey());
            }
        }
        Set<String> pairs = new HashSet<>();
        for (List<String> accounts : deviceToAccounts.values()) {
            for (int left = 0; left < accounts.size(); left++) {
                for (int right = left + 1; right < accounts.size(); right++) {
                    pairs.add(pair(accounts.get(left), accounts.get(right)));
                }
            }
        }
        return pairs;
    }

    private static String pair(String left, String right) {
        return left.compareTo(right) < 0 ? left + "|" + right : right + "|" + left;
    }
}
