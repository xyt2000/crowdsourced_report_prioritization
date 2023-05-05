/*
 * This file is part of the LIRE project: http://lire-project.net
 * LIRE is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * LIRE is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with LIRE; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 * We kindly ask you to refer the any or one of the following publications in
 * any publication mentioning or employing Lire:
 *
 * Lux Mathias, Savvas A. Chatzichristofis. Lire: Lucene Image Retrieval �C
 * An Extensible Java CBIR Library. In proceedings of the 16th ACM International
 * Conference on Multimedia, pp. 1085-1088, Vancouver, Canada, 2008
 * URL: http://doi.acm.org/10.1145/1459359.1459577
 *
 * Lux Mathias. Content Based Image Retrieval with LIRE. In proceedings of the
 * 19th ACM International Conference on Multimedia, pp. 735-738, Scottsdale,
 * Arizona, USA, 2011
 * URL: http://dl.acm.org/citation.cfm?id=2072432
 *
 * Mathias Lux, Oge Marques. Visual Information Retrieval using Java and LIRE
 * Morgan & Claypool, 2013
 * URL: http://www.morganclaypool.com/doi/abs/10.2200/S00468ED1V01Y201301ICR025
 *
 */
package net.semanticmetadata.lire.imageanalysis.features.global.accid;

/**
 * ACCID global feature as designed by Chrysanthi Iakovidou and implemented by Nektarios Anagnostopoulos. Main idea
 * is to find the most important edges on different scales and store them in a histogram along with a fuzzy color
 * scheme taken from the CEDD descriptor.
 *
 * @author Chrysanthi Iakovidou
 * @author Nektarios Anagnostopoulos
 * @author Mathias Lux
 */
public class PMasks {

    private int[][][] pMasks =
            {{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}},
                    {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}},
                    {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}},
                    {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}},
                    {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}},
                    {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 255, 255, 255}, {0, 0, 0, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}},
                    {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 255, 255, 255}, {0, 0, 0, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}},
                    {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 255, 255, 255}, {0, 0, 0, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}},
                    {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 255, 255, 255}, {0, 0, 0, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}},
                    {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 255, 255}, {0, 0, 0, 0, 0, 0, 255, 255, 255, 255}, {0, 0, 0, 0, 255, 255, 255, 255, 255, 255}},
                    {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 255, 255}, {0, 0, 0, 0, 0, 0, 255, 255, 255, 255}, {0, 0, 0, 0, 255, 255, 255, 255, 255, 255}, {0, 0, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}},
                    {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 255, 255}, {0, 0, 0, 0, 0, 0, 255, 255, 255, 255}, {0, 0, 0, 0, 255, 255, 255, 255, 255, 255}, {0, 0, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}},
                    {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 255, 255}, {0, 0, 0, 0, 0, 0, 255, 255, 255, 255}, {0, 0, 0, 0, 255, 255, 255, 255, 255, 255}, {0, 0, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}},
                    {{0, 0, 0, 0, 0, 0, 255, 255, 255, 255}, {0, 0, 0, 0, 255, 255, 255, 255, 255, 255}, {0, 0, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}},
                    {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 255}, {0, 0, 0, 0, 0, 0, 0, 0, 255, 255}, {0, 0, 0, 0, 0, 0, 0, 255, 255, 255}, {0, 0, 0, 0, 0, 0, 255, 255, 255, 255}, {0, 0, 0, 0, 0, 255, 255, 255, 255, 255}},
                    {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 255}, {0, 0, 0, 0, 0, 0, 0, 0, 255, 255}, {0, 0, 0, 0, 0, 0, 0, 255, 255, 255}, {0, 0, 0, 0, 0, 0, 255, 255, 255, 255}, {0, 0, 0, 0, 0, 255, 255, 255, 255, 255}, {0, 0, 0, 0, 255, 255, 255, 255, 255, 255}, {0, 0, 0, 255, 255, 255, 255, 255, 255, 255}},
                    {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 255}, {0, 0, 0, 0, 0, 0, 0, 0, 255, 255}, {0, 0, 0, 0, 0, 0, 0, 255, 255, 255}, {0, 0, 0, 0, 0, 0, 255, 255, 255, 255}, {0, 0, 0, 0, 0, 255, 255, 255, 255, 255}, {0, 0, 0, 0, 255, 255, 255, 255, 255, 255}, {0, 0, 0, 255, 255, 255, 255, 255, 255, 255}, {0, 0, 255, 255, 255, 255, 255, 255, 255, 255}, {0, 255, 255, 255, 255, 255, 255, 255, 255, 255}},
                    {{0, 0, 0, 0, 0, 0, 0, 0, 255, 255}, {0, 0, 0, 0, 0, 0, 0, 255, 255, 255}, {0, 0, 0, 0, 0, 0, 255, 255, 255, 255}, {0, 0, 0, 0, 0, 255, 255, 255, 255, 255}, {0, 0, 0, 0, 255, 255, 255, 255, 255, 255}, {0, 0, 0, 255, 255, 255, 255, 255, 255, 255}, {0, 0, 255, 255, 255, 255, 255, 255, 255, 255}, {0, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}},
                    {{0, 0, 0, 0, 0, 0, 255, 255, 255, 255}, {0, 0, 0, 0, 0, 255, 255, 255, 255, 255}, {0, 0, 0, 0, 255, 255, 255, 255, 255, 255}, {0, 0, 0, 255, 255, 255, 255, 255, 255, 255}, {0, 0, 255, 255, 255, 255, 255, 255, 255, 255}, {0, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}},
                    {{0, 0, 0, 0, 0, 255, 255, 255, 255, 255}, {0, 0, 0, 0, 255, 255, 255, 255, 255, 255}, {0, 0, 0, 255, 255, 255, 255, 255, 255, 255}, {0, 0, 255, 255, 255, 255, 255, 255, 255, 255}, {0, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}},
                    {{255, 255, 255, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}},
                    {{255, 255, 255, 255, 255, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 0, 0, 0, 0, 0, 0, 0, 0, 0}},
                    {{255, 255, 255, 255, 255, 255, 255, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 0, 0, 0, 0, 0, 0, 0}},
                    {{255, 255, 255, 255, 255, 255, 255, 255, 255, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 0, 0, 0, 0, 0}},
                    {{255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 0, 0, 0}},
                    {{255, 255, 255, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 0, 0, 0, 0, 0, 0, 0, 0, 0}},
                    {{255, 255, 255, 255, 255, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 0, 0, 0, 0, 0, 0, 0}},
                    {{255, 255, 255, 255, 255, 255, 255, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 0, 0, 0, 0, 0}},
                    {{255, 255, 255, 255, 255, 255, 255, 255, 255, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 0, 0, 0}},
                    {{255, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 0, 0, 0, 0, 0, 0, 0, 0, 0}},
                    {{255, 255, 255, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 0, 0, 0, 0, 0, 0, 0}},
                    {{255, 255, 255, 255, 255, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 0, 0, 0, 0, 0}},
                    {{255, 255, 255, 255, 255, 255, 255, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 0, 0, 0}},
                    {{255, 255, 255, 255, 255, 255, 255, 255, 255, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 0}},
                    {{255, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 0, 0, 0, 0, 0, 0, 0}},
                    {{255, 255, 255, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 0, 0, 0, 0, 0}},
                    {{255, 255, 255, 255, 255, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 0, 0, 0}},
                    {{255, 255, 255, 255, 255, 255, 255, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 0}},
                    {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 0, 0, 0, 0, 0, 0, 0}},
                    {{255, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 0, 0, 0, 0, 0}},
                    {{255, 255, 255, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 0, 0, 0}},
                    {{255, 255, 255, 255, 255, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 0}},
                    {{255, 255, 255, 255, 255, 255, 255, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}},
                    {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 0, 0, 0, 0, 0}},
                    {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 0, 0, 0, 0}},
                    {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 0, 0}},
                    {{255, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}},
                    {{255, 255, 255, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}},
                    {{255, 255, 255, 255, 255, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}},
                    {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 0, 0, 0, 0}},
                    {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}},
                    {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}},
                    {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}},
                    {{255, 255, 255, 255, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}},
                    {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}},
                    {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}},
                    {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}},
                    {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 0, 0, 0, 0, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 0, 0, 0}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, {255, 255, 255, 255, 255, 255, 255, 255, 255, 255}},
                    {{0, 255, 0, 255, 0, 255, 0, 255, 0, 255}, {255, 0, 255, 0, 255, 0, 255, 0, 255, 0}, {0, 255, 0, 255, 0, 255, 0, 255, 0, 255}, {255, 0, 255, 0, 255, 0, 255, 0, 255, 0}, {0, 255, 0, 255, 0, 255, 0, 255, 0, 255}, {255, 0, 255, 0, 255, 0, 255, 0, 255, 0}, {0, 255, 0, 255, 0, 255, 0, 255, 0, 255}, {255, 0, 255, 0, 255, 0, 255, 0, 255, 0}, {0, 255, 0, 255, 0, 255, 0, 255, 0, 255}, {255, 0, 255, 0, 255, 0, 255, 0, 255, 0}}};


    private int[] MaskWhite = {10, 30, 50, 70, 90, 20, 40, 60, 80, 12, 30, 50, 70, 88, 15, 28, 45, 64, 79, 85, 12, 30, 50, 70, 88, 20, 40, 60, 80, 10, 30, 50, 70, 90, 20, 40, 60, 80, 12, 30, 50, 70, 88, 15, 21, 36, 55, 72, 85, 12, 30, 50, 70, 88, 20, 40, 60, 80};

    public int[][][] getPmasks() {
        return pMasks;
    }

    public int[] getMaskWhite() {
        return MaskWhite;
    }


}
