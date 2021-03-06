/*
 * The MIT License
 * Copyright © 2021 Daniel Dias
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.medium.danieldiasjava.tomee.service.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import com.medium.danieldiasjava.tomee.annotations.Service;
import com.medium.danieldiasjava.tomee.dto.BookDTO;
import com.medium.danieldiasjava.tomee.repository.BookEmbeddedStorageRepository;
import com.medium.danieldiasjava.tomee.service.BookStoreEmbeddedStorageService;



/**
 * @author Daniel Dias
 *
 */
@Service
@ApplicationScoped
public class BookStoreEmbeddedStorageServiceImpl implements BookStoreEmbeddedStorageService {

	@Inject
	private BookEmbeddedStorageRepository bookEmbeddedStorageRepository;
	
	@Inject
	private Event<BookDTO> bookEvent;
	
	@Override
	public List<BookDTO> getBooks() {
		return this.bookEmbeddedStorageRepository.getBooks();
	}

	@Override
	public void saveBook(BookDTO book) {
		this.bookEmbeddedStorageRepository.saveBook(book);
		this.bookEvent.fire(book);
	}
}