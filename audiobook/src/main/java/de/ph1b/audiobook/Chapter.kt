package de.ph1b.audiobook

import android.util.SparseArray
import de.ph1b.audiobook.misc.NaturalOrderComparator
import java.io.File

/**
 * Represents a chapter in a book.
 *
 * @author Paul Woitaschek
 */
data class Chapter(
    val file: File,
    val name: String,
    val duration: Int,
    val fileLastModified: Long,
    val marks: SparseArray<String>
) : Comparable<Chapter> {

  init {
    check(name.isNotEmpty())
  }

  override fun compareTo(other: Chapter): Int {
    return NaturalOrderComparator.fileComparator.compare(file, other.file)
  }
}