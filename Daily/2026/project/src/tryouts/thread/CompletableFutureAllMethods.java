package tryouts.thread;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureAllMethods {

    public static void main(String[] args) throws Exception {

        // =========================================================
        // 1. supplyAsync()
        // =========================================================
        CompletableFuture<String> supplyFuture =
                CompletableFuture.supplyAsync(() -> {
                    sleep(500);
                    return "Hello";
                });

        System.out.println("supplyAsync: " + supplyFuture.get());


        // =========================================================
        // 2. runAsync()
        // No return value
        // =========================================================
        CompletableFuture<Void> runFuture =
                CompletableFuture.runAsync(() -> {
                    System.out.println("runAsync: Running background task");
                });

        runFuture.get();


        // =========================================================
        // 3. thenApply()
        // Transform the result
        // =========================================================
        CompletableFuture<String> applyFuture =
                CompletableFuture.supplyAsync(() -> "hello")
                        .thenApply(value -> value.toUpperCase());

        System.out.println("thenApply: " + applyFuture.get());


        // =========================================================
        // 4. thenAccept()
        // Consume the result, no new result
        // =========================================================
        CompletableFuture<Void> acceptFuture =
                CompletableFuture.supplyAsync(() -> "Hello World")
                        .thenAccept(value ->
                                System.out.println("thenAccept: " + value));

        acceptFuture.get();


        // =========================================================
        // 5. thenRun()
        // Run something after completion
        // Does not receive previous result
        // =========================================================
        CompletableFuture<Void> runAfterFuture =
                CompletableFuture.supplyAsync(() -> "Some Result")
                        .thenRun(() ->
                                System.out.println("thenRun: Previous task completed"));

        runAfterFuture.get();


        // =========================================================
        // 6. thenApplyAsync()
        // Transformation runs asynchronously
        // =========================================================
        CompletableFuture<String> applyAsyncFuture =
                CompletableFuture.supplyAsync(() -> "hello")
                        .thenApplyAsync(value -> value.toUpperCase());

        System.out.println("thenApplyAsync: " + applyAsyncFuture.get());


        // =========================================================
        // 7. thenAcceptAsync()
        // =========================================================
        CompletableFuture<Void> acceptAsyncFuture =
                CompletableFuture.supplyAsync(() -> "Hello Async")
                        .thenAcceptAsync(value ->
                                System.out.println("thenAcceptAsync: " + value));

        acceptAsyncFuture.get();


        // =========================================================
        // 8. thenRunAsync()
        // =========================================================
        CompletableFuture<Void> runAsyncFuture =
                CompletableFuture.supplyAsync(() -> "Done")
                        .thenRunAsync(() ->
                                System.out.println("thenRunAsync: Task completed"));

        runAsyncFuture.get();


        // =========================================================
        // 9. thenCompose()
        //
        // Used when the next operation itself returns
        // CompletableFuture.
        // =========================================================
        CompletableFuture<String> composeFuture =
                CompletableFuture
                        .supplyAsync(() -> 100)
                        .thenCompose(id -> getUserName(id));

        System.out.println("thenCompose: " + composeFuture.get());


        // =========================================================
        // 10. thenComposeAsync()
        // =========================================================
        CompletableFuture<String> composeAsyncFuture =
                CompletableFuture
                        .supplyAsync(() -> 200)
                        .thenComposeAsync(id -> getUserName(id));

        System.out.println("thenComposeAsync: " + composeAsyncFuture.get());


        // =========================================================
        // 11. thenCombine()
        //
        // Combine two independent CompletableFutures
        // =========================================================
        CompletableFuture<String> userFuture =
                CompletableFuture.supplyAsync(() -> "John");

        CompletableFuture<String> orderFuture =
                CompletableFuture.supplyAsync(() -> "Order-123");

        CompletableFuture<String> combinedFuture =
                userFuture.thenCombine(
                        orderFuture,
                        (user, order) -> user + " -> " + order
                );

        System.out.println("thenCombine: " + combinedFuture.get());


        // =========================================================
        // 12. thenCombineAsync()
        // =========================================================
        CompletableFuture<String> combineAsyncFuture =
                userFuture.thenCombineAsync(
                        orderFuture,
                        (user, order) -> user + " -> " + order
                );

        System.out.println("thenCombineAsync: "
                + combineAsyncFuture.get());


        // =========================================================
        // 13. thenAcceptBoth()
        //
        // Consume results from two futures
        // =========================================================
        CompletableFuture<Void> acceptBothFuture =
                userFuture.thenAcceptBoth(
                        orderFuture,
                        (user, order) ->
                                System.out.println(
                                        "thenAcceptBoth: "
                                                + user + " has " + order)
                );

        acceptBothFuture.get();


        // =========================================================
        // 14. runAfterBoth()
        //
        // Runs after BOTH futures complete.
        // Does not receive their results.
        // =========================================================
        CompletableFuture<Void> afterBothFuture =
                userFuture.runAfterBoth(
                        orderFuture,
                        () -> System.out.println(
                                "runAfterBoth: Both completed")
                );

        afterBothFuture.get();


        // =========================================================
        // 15. applyToEither()
        //
        // Whichever future finishes first.
        // =========================================================
        CompletableFuture<String> server1 =
                CompletableFuture.supplyAsync(() -> {
                    sleep(1000);
                    return "Server 1";
                });

        CompletableFuture<String> server2 =
                CompletableFuture.supplyAsync(() -> {
                    sleep(500);
                    return "Server 2";
                });

        CompletableFuture<String> eitherFuture =
                server1.applyToEither(
                        server2,
                        result -> result + " responded first"
                );

        System.out.println("applyToEither: "
                + eitherFuture.get());


        // =========================================================
        // 16. acceptEither()
        // =========================================================
        CompletableFuture<Void> acceptEitherFuture =
                server1.acceptEither(
                        server2,
                        result -> System.out.println(
                                "acceptEither: " + result)
                );

        acceptEitherFuture.get();


        // =========================================================
        // 17. runAfterEither()
        // =========================================================
        CompletableFuture<Void> runAfterEitherFuture =
                server1.runAfterEither(
                        server2,
                        () -> System.out.println(
                                "runAfterEither: One server completed")
                );

        runAfterEitherFuture.get();


        // =========================================================
        // 18. allOf()
        //
        // Wait for ALL futures.
        // =========================================================
        CompletableFuture<String> f1 =
                CompletableFuture.supplyAsync(() -> "A");

        CompletableFuture<String> f2 =
                CompletableFuture.supplyAsync(() -> "B");

        CompletableFuture<String> f3 =
                CompletableFuture.supplyAsync(() -> "C");

        CompletableFuture<Void> all =
                CompletableFuture.allOf(f1, f2, f3);

        all.get();

        System.out.println("allOf: "
                + f1.get() + ", "
                + f2.get() + ", "
                + f3.get());


        // =========================================================
        // 19. anyOf()
        //
        // Wait for the FIRST future.
        // =========================================================
        CompletableFuture<String> slow =
                CompletableFuture.supplyAsync(() -> {
                    sleep(1000);
                    return "Slow";
                });

        CompletableFuture<String> fast =
                CompletableFuture.supplyAsync(() -> {
                    sleep(300);
                    return "Fast";
                });

        CompletableFuture<Object> any =
                CompletableFuture.anyOf(slow, fast);

        System.out.println("anyOf: " + any.get());


        // =========================================================
        // 20. exceptionally()
        //
        // Handle an exception and provide fallback value.
        // =========================================================
        CompletableFuture<Object> exceptionFuture =
                CompletableFuture.supplyAsync(() -> {
                    throw new RuntimeException("Something went wrong");
                })
                .exceptionally(exception -> {
                    System.out.println(
                            "exceptionally: " + exception.getMessage());
                    return "Default Value";
                });

        System.out.println("exceptionally result: "
                + exceptionFuture.get());


        // =========================================================
        // 21. handle()
        //
        // Handles BOTH success and failure.
        // =========================================================
        CompletableFuture<Object> handleFuture =
                CompletableFuture.supplyAsync(() -> {
                    throw new RuntimeException("Database error");
                })
                .handle((result, exception) -> {

                    if (exception != null) {
                        System.out.println(
                                "handle: " + exception.getMessage());

                        return "Fallback";
                    }

                    return result;
                });

        System.out.println("handle result: "
                + handleFuture.get());


        // =========================================================
        // 22. whenComplete()
        //
        // Execute something after completion.
        // Usually useful for logging.
        // =========================================================
        CompletableFuture<String> completeFuture =
                CompletableFuture.supplyAsync(() -> "Success")
                        .whenComplete((result, exception) -> {

                            System.out.println(
                                    "whenComplete result: " + result);

                            if (exception != null) {
                                System.out.println(
                                        "whenComplete error: "
                                                + exception.getMessage());
                            }
                        });

        completeFuture.get();


        // =========================================================
        // 23. complete()
        //
        // Manually complete a CompletableFuture.
        // =========================================================
        CompletableFuture<String> manualFuture =
                new CompletableFuture<>();

        manualFuture.complete("Manually Completed");

        System.out.println("complete: "
                + manualFuture.get());


        // =========================================================
        // 24. completeExceptionally()
        //
        // Manually complete with an exception.
        // =========================================================
        CompletableFuture<String> failedFuture =
                new CompletableFuture<>();

        failedFuture.completeExceptionally(
                new RuntimeException("Manual failure")
        );

        try {
            failedFuture.get();
        } catch (ExecutionException e) {
            System.out.println(
                    "completeExceptionally: "
                            + e.getCause().getMessage());
        }


        // =========================================================
        // 25. orTimeout()
        //
        // Java 9+
        // =========================================================
        CompletableFuture<String> timeoutFuture =
                CompletableFuture.supplyAsync(() -> {
                    sleep(3000);
                    return "Finished";
                }).orTimeout(1, TimeUnit.SECONDS);

        try {
            System.out.println(
                    "orTimeout: " + timeoutFuture.get());
        } catch (Exception e) {
            System.out.println(
                    "orTimeout: " + e.getCause());
        }


        // =========================================================
        // 26. completeOnTimeout()
        //
        // Java 9+
        // Returns default value if timeout occurs.
        // =========================================================
        CompletableFuture<String> defaultFuture =
                CompletableFuture.supplyAsync(() -> {
                    sleep(3000);
                    return "Real Result";
                }).completeOnTimeout(
                        "Default Result",
                        1,
                        TimeUnit.SECONDS
                );

        System.out.println(
                "completeOnTimeout: "
                        + defaultFuture.get());


        // =========================================================
        // 27. failedFuture()
        //
        // Java 9+
        // Creates an already failed future.
        // =========================================================
        CompletableFuture<String> alreadyFailed =
                CompletableFuture.failedFuture(
                        new RuntimeException("Already failed")
                );

        alreadyFailed.exceptionally(exception -> {
            System.out.println(
                    "failedFuture: "
                            + exception.getMessage());
            return null;
        }).get();


        // =========================================================
        // 28. completedFuture()
        //
        // Creates an already completed future.
        // =========================================================
        CompletableFuture<String> alreadyCompleted =
                CompletableFuture.completedFuture("Already Done");

        System.out.println(
                "completedFuture: "
                        + alreadyCompleted.get());


        System.out.println("\nAll examples completed.");
    }


    // =============================================================
    // Helper method returning CompletableFuture
    // =============================================================
    private static CompletableFuture<String> getUserName(int id) {

        return CompletableFuture.supplyAsync(() -> {
            sleep(300);
            return "User-" + id;
        });
    }


    // =============================================================
    // Helper sleep method
    // =============================================================
    private static void sleep(long millis) {

        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}