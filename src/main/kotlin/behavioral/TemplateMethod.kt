package behavioral

/**
 *  Template Method Pattern
 *  The template method is a method in a superclass, usually an abstract superclass, and defines the skeleton of an
 *  operation in terms of a number of high-level steps. These steps are themselves implemented by additional helper
 *  methods in the same class as the template method.
 *
 *  Source: https://en.wikipedia.org/wiki/Template_method_pattern
 *
 *
 *                             +-------------------+
 *     +--------+              |   <<abstract>>    |
 *     | Client |<>----------->| AbstractAlgorithm |
 *     +--------+              +-------------------+
 *                             |+ algorithm()      |
 *                             |- step1() {a}      |
 *                             |- step2() {a}      |
 *                             +-------------------+
 *                                     ^
 *                                     |
 *                               ______|________
 *                              |               |
 *                       +--------------+   +--------------+
 *                       |  Algorithm1  |   |  Algorithm2  |
 *                       +--------------+   +--------------+
 *                       |- step1() {o} |   |- step1() {o} |
 *                       |- step2() {o} |   |- step2() {o} |
 *                       +--------------+   +--------------+
 *
 */

/*** Standard (Java) Approach ***/

abstract class AbstractAlgorithm {
    abstract fun step1(): String
    abstract fun step2(): String

    fun algorithm() : String {
        return "${step1()}${step2()}"
    }
}

class Algorithm1 : AbstractAlgorithm() {
    override fun step1(): String {
        return "A1S1"
    }

    override fun step2(): String {
        return "A1S2"
    }
}

class Algorithm2 : AbstractAlgorithm() {
    override fun step1(): String {
        return "A2S1"
    }

    override fun step2(): String {
        return "A2S2"
    }
}

/*** Kotlin Approach ***/