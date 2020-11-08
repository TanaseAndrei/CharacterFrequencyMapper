package org.ucv.interfaces;

import org.ucv.implementations.FileInformation;

import java.util.List;

/**
 * Interface used to retrieve the content and its informations
 * about a file.
 */
public interface FileInformationResolver {

    /**
     *
     * @return a FileInformation object containing
     * the informations about the file like, number of
     * characters, its lines etc.
     */
    FileInformation extractData();
}
